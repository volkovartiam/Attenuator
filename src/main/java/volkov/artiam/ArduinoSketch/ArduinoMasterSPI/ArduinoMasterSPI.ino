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
//Отправка команды в следующим виде "ATT;X.X;"
//X.X - значения аттенюации (округление автоматически до 0.5)
String ATT = "ATT;" ;
String OK_Att_0_0_dB  = "OK;Att;0.0;" ;
String OK_Att_0_5_dB  = "OK;Att;0.5;" ;
String OK_Att_15_5_dB  = "OK;Att;31.5 dB;" ;


//Команда для включения автоматического изменения шага аттенюатора
//При команде отключения аттенюатор переводится в ослабление 31,5 дБ
String ATT_AUTO_ON  = "ATT_AUTO;ON;" ;
String ATT_AUTO_OFF  = "ATT_AUTO;OFF;" ;


//Телеметрия получаемая от аттенюатора (должна совпадать с установленным значением)
String TM = "TM_ATT;" ;                    // Телеметрия от аттенюатора


String command = "";                       // Переменная для хранения команды
///////////////////////////////////////////////////////////////////////////////////////////////



// Настройки порта
int delaySerialPrint = 100;
int serialBaudRate = 9600;

/**/
// Настройки таймеров
uint32_t timerReadPort;
uint32_t timerReadPortDelay = 200;


uint32_t timer_OK_TM, timer_RK_TM;
uint32_t timer_TM_Delay = 200;

/*
// Телеметрия   
int tm_OK_counter = 0;                    // Счетчик для перебора цепей телеметрии основного канала
int tm_OK_counter_MAX_VALUE = 27;         // Количество цепей телеметрии
String tmOk[27];                          // Массив хранит команды для получения телеметрии
*/


////// Конфигурация выводов
int LED = 13;                     

int NEG_3_3V = 3;
int POS_3_3V = 4;


//Установка режимов SPI
SPISettings settingsA(1000000, MSBFIRST, SPI_MODE0);
int LE = 5;



//////////////////////////////////////////// setup
void setup(){
    pinMode(LED, OUTPUT);
    digitalWrite(LED, LOW);

    pinMode(NEG_3_3V, OUTPUT);
    digitalWrite(NEG_3_3V, LOW);

    pinMode(POS_3_3V, OUTPUT);
    digitalWrite(POS_3_3V, LOW);

    pinMode(SS, OUTPUT);
    digitalWrite(SS, LOW);

    Serial.begin(serialBaudRate);  // Открываем порт на скорости 9600 бод.
}


void loop(){

    if (millis() - timerReadPort >= timer_TM_Delay ) {         // чтение порта
        timerReadPort = millis();                                  // сброс таймера
        readFromPort();
    }


    /*
    if (millis() - timer_OK_TM >= timer_TM_Delay) {                 // для перебора цепей телеметрии основного канала
        timer_OK_TM = millis();                                     // сброс таймера
     
        if(isAutoTM_OK) {                                           // Получение ТМ основного канала в автоматическом режиме
            //printTmByCommand_OK( tmOk[tm_OK_counter] );                   // Вывод текущего значения ТМ и далее перебор  
            setCommand(tmOk[tm_OK_counter]);
            tm_OK_counter++;          
            if( tm_OK_counter == tm_OK_counter_MAX_VALUE  ){
                tm_OK_counter = 0;
            }
        }
    }
  */
   

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
      Serial.print(str);
      delay(delaySerialPrint);
}






//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
void setCommand(String com){

    setLED(com);
    getVersion(com);

    setNEG_3_3V(com);
    setPOS_3_3V(com);

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






/////////// Управление аттенюатором
void att_OK(String coms ){
  /*
  boolean isAttOK = OK_Att.equals( coms.substring(0, OK_Att.length() ) );
  if( isAttOK ) {

    if( is_VKL1_ON()  ){
 
          
          ////////////////////////////////////////////////////////////////////////////////////// 
          if( coms.equals(OK_Att_3_5_dB  ) ) {
                setSPI_OK(7);
          }         
          if( coms.equals(OK_Att_3_0_dB  ) ) {
                setSPI_OK(6);
          }
          if( coms.equals(OK_Att_2_5_dB  ) ) {
                setSPI_OK(5);
          }         
          if( coms.equals(OK_Att_2_0_dB  ) ) {
                setSPI_OK(4);
          }

          //////////////////////////////////////////////////////////////////////////////////////           
          if( coms.equals(OK_Att_1_5_dB  ) ) {
                setSPI_OK(3);
          }         
          if( coms.equals(OK_Att_1_0_dB  ) ) {
                setSPI_OK(2);
          }        
          if( coms.equals(OK_Att_0_5_dB  ) ) {
                setSPI_OK(1);
          }         
          if( coms.equals(OK_Att_0_0_dB  ) ) {
                setSPI_OK(0);
          }

          print_Serial(coms + good);    
          
    }  else {
          print_Serial(OK_Att_Error_5V_OK_OFF );                  
    } 
  }
  */
}


void setSPI_OK(int num){
    digitalWrite(LE, LOW);        
    SPI.transfer(num);    
    digitalWrite(LE, HIGH);
}


/////////// Получение телеметрии аттенюатора




                                  




