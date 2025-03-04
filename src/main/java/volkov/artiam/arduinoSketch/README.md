# Дополнительные материалы

Отправки команд без GUI на прямую через Arduino (см. рисунок 1 и рисунок 2).<br>
Осциллограммы SPI из datasheet и полученные на Arduino UNO (см. рисунок 3 и рисунок 4).<br>


Перечень команд: <br>
- LED;ON; <br>
- LED;OFF; <br>
- GET;VERSION; <br>
- NEG_3_3V;ON; <br>
- NEG_3_3V;OFF; <br>
- POS_3_3V;ON; <br>
- POS_3_3V;OFF; <br>
- ATT_AUTO;ON; <br>
- ATT_AUTO;OFF; <br>
- ATT;X.X; ,где X.X - значения аттенюации от 0.0 до 31.5 пример "ATT;0.5;" <br>

Значение телеметрии: 
TM_ATT;X; ,где X - значения полученное от аттенюатора (MISO) от 0 до 63 пример "TM_ATT;63;"  <br> 

Конфигурация выводов Arduino UNO: <br>
- int LED = 7; <br>
- int NEG_3_3V = 3; <br>
- int POS_3_3V = 4; <br>
- int LE = 5; <br>
- выводы SPI интерфейса (MOSI, MISO, SCK)  <br>  <br>


![view](https://github.com/volkovartiam/Attenuator/blob/main/src/main/java/volkov/artiam/arduinoSketch/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA_1.PNG?raw=true) <br>
Рисунок 1 <br>


![view](https://github.com/volkovartiam/Attenuator/blob/main/src/main/java/volkov/artiam/arduinoSketch/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA_2.PNG?raw=true) <br>
Рисунок 2 <br>


![view](https://github.com/volkovartiam/Attenuator/blob/main/src/main/java/volkov/artiam/arduinoSketch/Datasheet_SPI.PNG?raw=true) <br>
Рисунок 3 <br>


![view](https://github.com/volkovartiam/Attenuator/blob/main/src/main/java/volkov/artiam/arduinoSketch/SPI_Arduino_UNO.PNG?raw=true) <br>
Рисунок 4 <br>



