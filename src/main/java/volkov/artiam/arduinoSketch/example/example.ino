#include <SPI.h>

#define EN_0 2
#define EN_1 3
#define EN_2 4
#define EN_3 5
#define EN_4 6

#define A0_IN 10
#define A1_IN 9
#define A2_IN 8
#define A3_IN 7

#define cntrLED 11

byte cntrLEDbyte;                              //7 бит байта управления мультиплексером: Управление светодиодом 0 - выкл, 1 - вкл 0b10000000
byte multiplexerByte;                          //Байт управления мультиплексером
byte adressA0;                                 //4 бита байта управления мультиплексером: Задают адрес пульта от  0 до 15 0b00001111
byte adressA1;          
byte adressA2;
byte adressA3; 


String sp_startMarker = "start_tx";            // "start_tx"
int sp_startMarkerStatus;                      // Флаг состояния маркера
byte rdwr_cmd;                                 // 0 - write; 1 - read
byte uprx_config[39];                          //Байты контрольной суммы отправляемых данных
byte telemetry[89];                            //Байты контрольной суммы принимаемых данных
byte crc_tx = 0;                               //Контрольная сумма отправляемых данных
byte crc_rx = 0;                               //Контрольная сумма принимаемых данных
byte msb;                                      //Вспомогательная переменная при расчёте контрольной суммы
byte zero = 0;                                 //Нулевой байт для отправки в случае несоответсвия контрольной суммы

SPISettings settingsA(1000000, MSBFIRST, SPI_MODE0);            //Выбираем необходимый режим работы SPI

void setup() {
  Serial.begin(9600);                                          //Открываем порт Serial
  while (!Serial) ;
  SPI.begin();                                                 //Открываем порт SPI
  SPI.beginTransaction(settingsA);                             //Устанавливаем заданные настройки
  SPI.setClockDivider(SS, 84);                                 //Устанавливаем делитель частоты синхронизации
  
  pinMode(SS, HIGH);                                           //Устанавливаем высокий уровень на выходе SS
  
  pinMode(EN_0, OUTPUT);                                       //Настроиваем выходы Arduino
  pinMode(EN_1, OUTPUT); 
  pinMode(EN_2, OUTPUT); 
  pinMode(EN_3, OUTPUT); 
  pinMode(EN_4, OUTPUT); 
  digitalWrite(EN_4, LOW);
 
  pinMode(A0_IN, OUTPUT); 
  pinMode(A1_IN, OUTPUT); 
  pinMode(A2_IN, OUTPUT); 
  pinMode(A3_IN, OUTPUT); 

  digitalWrite(A0_IN, LOW);
  digitalWrite(A1_IN, LOW);
  digitalWrite(A2_IN, LOW); 
  digitalWrite(A3_IN, LOW);

  pinMode(cntrLED, OUTPUT); 
  digitalWrite(cntrLED, LOW);
  
  digitalWrite(EN_0, LOW);
}

void loop() {
  
  while (Serial.available()){                                          //Если на порте Serial появляются данные
    
    int bufferChar = Serial.read();                                    //Сохраняем первый байт на линии в переменную
    if (sp_startMarkerStatus < 8){                                     // поиск начала передачи "start_tx"
       if (sp_startMarker[sp_startMarkerStatus] == bufferChar)  {      //Если он совпадает с текущим символом "start_tx"
        sp_startMarkerStatus++;                                        //Увеличиваем числовую переменную на 1
      } else {                                                         //Если не совпадает
        sp_startMarkerStatus = 0;                                      //Обнуляем переменную
      }
    }
        
    else {                                                            // найден "start_tx", начинается прием данных
    
      switch (bufferChar){                                            // 1й байт - выбор устройства
         case 1:                                                      // 1 - упр-х
         
           while (Serial.available() == 0){                   
              delay(1);
            }
           rdwr_cmd = Serial.read();                                  // 2й байт - команда чтение/запись данных упр-х
 
          
           for (int i = 0; i < 39; i++){                              //прием данных (38Б)
              while (Serial.available() == 0) {
                delay(1);
              }   
            uprx_config[i] = Serial.read();                          //СОхранЯем данные в массив
           }
                    
          setPultParams( uprx_config[0] );                           //Вызываем функцию установки параметров пульта, отправляем в эту функцию байт управления мультиплексором

          uprx_config[1] = uprx_config[1]<<4;                        //формирование первого байта SPI: принимаем и устанавливаем адресс блока МП-Х
          bitSet(uprx_config[1],rdwr_cmd);                           //формирование первого байта SPI: принимаем и устанавливаем режим чтения и записи или только чтения
        
          
          crc_tx_calc ();                                            //Вызываем функцию расчёта контрольной суммы отправляемых данных              
          send_data_to_uprx_and_get_telemetry();                     //Вызываем функцию обмена данными с УПР-Х      
          crc_rx_calc();                                             //Вызываем функцию расчёта контрольной суммы принимаемых данных
          send_telemetry_to_pc();                                    //Вызываем функцию обмена данными с ПК          
          break;                                                     //Выходим из цикла, завершая программу
       
         default: break;
      }
    }
  }
}






void setPultParams(byte multiplexerByte){                           //Функция установки параметров пульта
  
  
           if (  (bitRead(multiplexerByte, 5) == 0) && (bitRead(multiplexerByte, 6) == 0) ) {           //Выбран ОК комплект А 
             digitalWrite(EN_0, LOW);
             digitalWrite(EN_1, HIGH);
             digitalWrite(EN_2, HIGH);
             digitalWrite(EN_3, HIGH);
             
           } else if (  (bitRead(multiplexerByte, 5) == 1) && (bitRead(multiplexerByte, 6) == 0) ) {    //Выбран ОК комплект Б
             digitalWrite(EN_0, HIGH);
             digitalWrite(EN_1, LOW);
             digitalWrite(EN_2, HIGH);
             digitalWrite(EN_3, HIGH);

           } else if (  (bitRead(multiplexerByte, 5) == 0) && (bitRead(multiplexerByte, 6) == 1) ) {    //Выбран РК комплект А
             digitalWrite(EN_0, HIGH);
             digitalWrite(EN_1, HIGH);
             digitalWrite(EN_2, LOW);
             digitalWrite(EN_3, HIGH);
             
           } else if (  (bitRead(multiplexerByte, 5) == 1) && (bitRead(multiplexerByte, 6) == 1) ) {    //Выбран РК комплект Б
             digitalWrite(EN_0, HIGH);
             digitalWrite(EN_1, HIGH);
             digitalWrite(EN_2, HIGH);
             digitalWrite(EN_3, LOW);
            }

           adressA0 = bitRead(multiplexerByte, 0);                    //Считываем адрес пульта
           adressA1 = bitRead(multiplexerByte, 1);               
           adressA2 = bitRead(multiplexerByte, 2); 
           adressA3 = bitRead(multiplexerByte, 3); 
           
           cntrLEDbyte = bitRead(multiplexerByte, 7); 

           if (cntrLEDbyte == 1) {                                  //Считываем байт управления светодиодом и устанавливаем соответствующий уровень
             digitalWrite(cntrLED, HIGH);
           } else {
             digitalWrite(cntrLED, LOW);
           }

           if (adressA3 == 1) {                                    //Формируем адрес пульта на физическом уровне
             digitalWrite(A3_IN, HIGH);
           } else {
             digitalWrite(A3_IN, LOW);
           }

           if (adressA2 == 1) {
             digitalWrite(A2_IN, HIGH);
           } else {
             digitalWrite(A2_IN, LOW);
           }           

           if (adressA1 == 1) {
             digitalWrite(A1_IN, HIGH);
           } else {
             digitalWrite(A1_IN, LOW);
           }

           if (adressA0 == 1 ) {
             digitalWrite(A0_IN, HIGH);
           } else {
             digitalWrite(A0_IN, LOW);
           }
 
}

void crc_tx_calc (){                                        //расчёт контрольной суммы отправляемых данных
  crc_tx = 0;
  for (int m = 1; m < 38; m++){
    for (int j = 7; j >= 0; j--){
      msb = bitRead(crc_tx, 7);
      crc_tx = crc_tx<<1;                                    // запоминаем ст. бит, сдвигаем влево
      bitWrite(crc_tx, 0, bitRead(uprx_config[m], j));       // в мл. бит записываем ст. бит данных
      if (msb==1) {
        crc_tx = crc_tx ^ 213;                               // если выброшенный бит=1, то XOR с полиномом
      }  
    }             
  }
  
  for (int k =7; k >= 0; k--){                                // проталкиваем данные целиком до последнего бита
    msb = bitRead(crc_tx, 7);
    crc_tx = crc_tx<<1;
    bitWrite(crc_tx, 0, 0);
    if (msb==1) {
      crc_tx = crc_tx ^ 213;
    }     
  }
  uprx_config[38] = crc_tx + uprx_config[38];                // конец расчета CRC.
}

void crc_rx_calc(){                                                     //Расчёт контрольной суммы принимаемых данных
      crc_rx = 0;
      for (int m = 1; m < 88; m++) {                                    // считаются все байты, кроме CRC
        for (int j = 7; j >= 0; j--){
          msb = bitRead(crc_rx, 7);
          crc_rx = crc_rx<<1;
          bitWrite(crc_rx, 0, bitRead(telemetry[m], j));
          if (msb==1) {
            crc_rx = crc_rx ^ 213;
          }     
        }             
      }
      for (int k =7; k >= 0; k--){
        msb = bitRead(crc_rx, 7);
        crc_rx = crc_rx<<1;
        bitWrite(crc_rx, 0, 0);
        if (msb==1) {
          crc_rx = crc_rx ^ 213;
        }     
      }
}                                                                       // конец расчета CRC

void send_telemetry_to_pc(){
    for (int i = 1; i < 89; i++){                                       // выдача данных
      Serial.write(telemetry[i]); 
      delay(1);
    }
    if (telemetry[88]==crc_rx) {                                        // выдача флага корректности CRC
      Serial.write(1);
    } else {Serial.write(zero);
    }
}

void send_data_to_uprx_and_get_telemetry(){
    SPI.transfer(67); 
    SPI.transfer(122); 
    SPI.transfer(103);
    
    for (int i = 1; i < 39; i++){                                       //38Б
      telemetry[i-1] = SPI.transfer(uprx_config[i]);
    }
    for (int i = 38; i < 89; i++) {                                     //51Б
      telemetry[i] = SPI.transfer(0);
    }
}

