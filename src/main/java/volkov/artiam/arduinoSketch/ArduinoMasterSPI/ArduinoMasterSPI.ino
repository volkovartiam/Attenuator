#include <SPI.h>


//Команды
//Команды для включения/отключения светодиода и полечения версии программы
String LED_ON = "LED;ON;";
String LED_OFF  = "LED;OFF;";

String VERSION_GET  = "GET;VERSION;" ;
String VERSION = "0.10;";


//Команды для подачи высокого/низкого логического уровня цепей -3,3В и +3,3В
String NEG_3_3V_ON  = "NEG_3_3V;ON;";
String NEG_3_3V_OFF  = "NEG_3_3V;OFF;";

String POS_3_3V_ON  = "POS_3_3V;ON;";
String POS_3_3V_OFF  = "POS_3_3V;OFF;";


//Команда для отправки значения аттенюатора в диапазоне от 0 до 31,5 дБ
//Отправка команды в следующим виде "ATT;X.X;" где X.X - значения аттенюации от 0.0 до 31.5 пример "ATT;0.5;"
String ATT = "ATT;" ;
//Команда для включения автоматического изменения шага аттенюатора, при команде отключения аттенюатор переводится в ослабление 31,5 дБ
String ATT_AUTO_ON  = "ATT_AUTO;ON;" ;
String ATT_AUTO_OFF  = "ATT_AUTO;OFF;" ;

//Телеметрия получаемая от аттенюатора (должна совпадать с установленным значением)
String TM_ATT = "TM_ATT;" ;  
String TM_ATT_Postfix = ";" ;                  


String command = "";                       // Переменная для хранения команды
///////////////////////////////////////////////////////////////////////////////////////////////

bool isAutoATT = false;

int minValueSPI = 0;
int maxValueSPI = 63;
int currentSPI = 63;

int delaySPI = 10;

// Настройки порта
int delaySerialPrint = 25;
int serialBaudRate = 9600;



// Настройки таймеров
uint32_t timerReadPort;
uint32_t timerReadPortDelay = 25;

uint32_t timer_ATT_AUTO;
uint32_t timer_ATT_AUTO_Delay = 500;



////// Конфигурация выводов
int LED = 7;

int NEG_3_3V = 3;
int POS_3_3V = 4;

SPISettings settingsA(1000000, MSBFIRST, SPI_MODE0);            //Выбираем необходимый режим работы SPI
int LE = 5;



void setup() {

    //GPIO
    pinMode(LED, OUTPUT);
    digitalWrite(LED, LOW);

    pinMode(NEG_3_3V, OUTPUT);
    digitalWrite(NEG_3_3V, LOW);

    pinMode(POS_3_3V, OUTPUT);
    digitalWrite(POS_3_3V, LOW);

    //Serial
    Serial.begin(serialBaudRate);  // Открываем порт на скорости 9600 бод.

    //SPI
    pinMode(LE, OUTPUT);
    digitalWrite(LE, LOW);

    SPI.begin();                                                 //Открываем порт SPI
    SPI.beginTransaction(settingsA);                             //Устанавливаем заданные настройки
    //SPI.setClockDivider(SS, 84);                                 //Устанавливаем делитель частоты синхронизации

    pinMode(SS, HIGH);                                           //Устанавливаем высокий уровень на выходе SS

}



void loop() {

    if (millis() - timerReadPort >= timerReadPortDelay ) {          // чтение порта
      timerReadPort = millis();                                     // сброс таймера
      readFromPort();
    }


    if (millis() - timer_ATT_AUTO >= timer_ATT_AUTO_Delay) {        // для перебора цепей телеметрии основного канала
        timer_ATT_AUTO = millis();                                  // сброс таймера
    
        if(isAutoATT) {                                           // Получение ТМ основного канала в автоматическом режиме
            runAttAuto();
        }
    }



}



void readFromPort(){

  if(Serial.available()){
      char ch = Serial.read();
      if(ch == '\n') {
        if(command.length() > 1){
              command = command.substring(0, command.length() - 1 );      //исключаем символ переноса строки
        }
        setCommand(command);
        command = "";
      }
      else {
          command += ch;
          if(command.length() > 25 ) {
            command = "";
          }
      }
  }
}



void print_to_serial(String str){
    //Serial.println(str);
    Serial.print(str);
    delay(delaySerialPrint);
}



/////////////////////////////////////////////////////////////////////////////////////////////
void setCommand(String com){

  setLED(com);
  getVersion(com);

  setNEG_3_3V(com);
  setPOS_3_3V(com);

  setATT(com);
  setATT_AUTO(com);
}




/////////// Управление светодиодами
void setLED( String coms ){
    if(coms.equals(LED_ON) ){
      digitalWrite(LED, HIGH);
      print_to_serial(LED_ON + "OK");
    }
    if(coms.equals(LED_OFF) ){
      digitalWrite(LED, LOW);
      print_to_serial(LED_OFF + "OK");
    }
}


/////////// Получение версии ПО
void getVersion( String coms ){
    if(coms.equals(VERSION_GET) ){
      print_to_serial("Current version " + VERSION);
    }
}



/////////// Управление -3.3V
void setNEG_3_3V( String coms ){
    if(coms.equals(NEG_3_3V_ON) ){
      digitalWrite(NEG_3_3V, HIGH);
      print_to_serial(NEG_3_3V_ON + "OK");
    }
    if(coms.equals(NEG_3_3V_OFF) ){
      digitalWrite(NEG_3_3V, LOW);
      print_to_serial(NEG_3_3V_OFF + "OK");
    }
}


/////////// Управление +3.3V
void setPOS_3_3V( String coms ){
    if(coms.equals(POS_3_3V_ON) ){
      digitalWrite(POS_3_3V, HIGH);
      print_to_serial(POS_3_3V_ON + "OK");
    }
    if(coms.equals(POS_3_3V_OFF) ){
      digitalWrite(POS_3_3V, LOW);
      print_to_serial(POS_3_3V_OFF + "OK");
    }
}


/////////// Управление аттенюацией
void setATT(String parsedCommand){

  if(parsedCommand.startsWith(ATT) ){

    String string_withNumber = getNumberInATTCommand(parsedCommand);
    if(checkIsValid(string_withNumber) ) {

      float val_ATT = string_withNumber.toFloat();
      int val_ATT_SPI = (int) (val_ATT/0.5);

      if( val_ATT_SPI <= maxValueSPI ){
        setATT_SPI(val_ATT_SPI);
      }
    }else {
      //setATT_SPI(maxValueSPI);
      Serial.print("Command mistake set att = ");
      setATT_MAX_SPI();
    }
  }

}


String getNumberInATTCommand(String str){
byte divider = str.indexOf(';');
// String string_1 = str.substring(0, divider);    // создаём строку с первым числом
//print_to_serial("String 1 = " + string_1);

String string_withNumber = str.substring(divider + 1);   // создаём строку со вторым числом
divider = string_withNumber.indexOf(';');
string_withNumber = string_withNumber.substring(0, divider);
// print_to_serial("String with number =" + string_withNumber);
return string_withNumber;
}


bool checkIsValid(String str){
bool isValid = false;

int VALID_LENGTH_3 = 3;
if(str.length() == VALID_LENGTH_3) {
  char firstChar = str.charAt(0);
  bool firstCharIsDigit = isDigit(firstChar);

  char secondChar = str.charAt(1);
  bool secondCharIsDot = secondChar == '.';

  char thirdChar = str.charAt(2);
  bool thirdCharIsDigit = isDigit(thirdChar);

  isValid = (firstCharIsDigit && secondCharIsDot && thirdCharIsDigit);
  //print_to_serial("VALID_LENGTH_3");
}

int VALID_LENGTH_4 = 4;
if(str.length() == VALID_LENGTH_4) {
  char firstChar = str.charAt(0);
  bool firstCharIsDigit = isDigit(firstChar);

  char secondChar = str.charAt(1);
  bool secondCharIsDot = isDigit(secondChar);

  char thirdChar = str.charAt(2);
  bool thirdCharIsDigit = thirdChar == '.';

  char fourthChar = str.charAt(3);
  bool fourthCharIsDigit = isDigit(fourthChar);

  isValid = (firstCharIsDigit && secondCharIsDot && thirdCharIsDigit && fourthCharIsDigit);
  //print_to_serial("VALID_LENGTH_4");
}

return isValid;
}



/////////// Управление аттенюатором в автоматическом режиме
void setATT_AUTO( String coms ){
    if(coms.equals(ATT_AUTO_ON) ){
      isAutoATT = true;
    }
    if(coms.equals(ATT_AUTO_OFF) ){
      isAutoATT = false;
      setATT_MAX_SPI();
    }
}

void runAttAuto(){
  setATT_SPI(currentSPI);
  currentSPI = currentSPI - 1;
  if(currentSPI < 0){
    currentSPI = maxValueSPI;
  }
}


/*
void setATT_Serial(int num){
  Serial.print(TM_ATT);
  Serial.print(num, DEC);
  Serial.print(TM_ATT_Postfix);
}

void setATT_MAX_Serial(){
  setATT_Serial(maxValueSPI);
}
*/


/////////// Установка значение аттенюации по интерфейсу SPI
void setATT_SPI(int num){
  digitalWrite(LE, LOW);
  byte tm = SPI.transfer(num);
  digitalWrite(LE, HIGH);
  print_to_serial_ATT_TM(tm);
}

void setATT_MAX_SPI(){
  setATT_SPI(maxValueSPI);
}


void print_to_serial_ATT_TM(byte num){
  Serial.print(TM_ATT);
  Serial.print(num, DEC);
  Serial.print(TM_ATT_Postfix);
  delay(delaySPI);
}







