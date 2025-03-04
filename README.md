# Attenuator

Программа для управления макетом аттенюатором ADRF5720 через последовательный порт и Arduino. 


Внешний вид программы для управления (GUI) <br>
![view](https://github.com/volkovartiam/Attenuator/blob/main/src/main/java/volkov/artiam/arduinoSketch/Attenuator_GUI.PNG?raw=true) <br>

Краткое описание управления:
- "Подключение"/"Отключение" для работы с COM-портом;
- "Контроль ВКЛ"/"Контроль ОТКЛ" вспомогательные команды для отладки;
- "-3,3В" и "3,3В" для включения/отключения соответвующих напряжений;
- "Установить" для установки значения аттенюации;
- "Auto" для изменения дискретов аттенюатора в автоматическом режиме.
- Для отображение отправленных команд консоль справа (ТХ) для полученных слева (RX).
 <br> <br>

Ссылки для работы с программой и [дополнительные материалы](https://github.com/volkovartiam/Attenuator/tree/main/src/main/java/volkov/artiam/arduinoSketch):
- Attenuator GUI можно скачать по ссылке [GitHub](https://github.com/volkovartiam/Attenuator/blob/main/out/artifacts/Attenuator_jar/Attenuator.jar) <br>
- ПО Arduino (использовался Arduino UNO) для ознакомления работы с Attenuator GUI [GitHub](https://github.com/volkovartiam/Attenuator/blob/main/src/main/java/volkov/artiam/arduinoSketch/ArduinoMaster_SPI_GUI/ArduinoMaster_SPI_GUI.ino) <br>
- ПО Arduino для работы непосредственно с макетом и Attenuator GUI [GitHub](https://github.com/volkovartiam/Attenuator/blob/main/src/main/java/volkov/artiam/arduinoSketch/ArduinoMasterSPI/ArduinoMasterSPI.ino) <br>
(написано для Arduino UNO, возможно лучше использовать Arduino DUE, определим по результатам макетирования)


