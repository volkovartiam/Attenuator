
// Настройки порта
int delaySerialPrint = 1500;
int serialBaudRate = 9600;




//////////////////////////////////////////////////////////////////////////////////////////////// Иициализация
void initState(){

    Serial.begin(serialBaudRate);  // Открываем порт на скорости 9600 бод.
}




//////////////////////////////////////////// setup
void setup(){
    initState();
}


void loop(){
      Serial.print("OK;TM;GND;0,000;");
      delay(delaySerialPrint);    
}



