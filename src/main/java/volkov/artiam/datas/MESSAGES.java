package volkov.artiam.datas;

public enum MESSAGES {

    //Arduino
    // При попытке задать параметры при этом порт отсутствует
    NO_PORTS_WITH_THAT_NAME("COM-порт с таким именем отсутствует"),
    // Unable to create a serial port object from the invalid port descriptor
    // При ошибке SerialPortInvalidPortException (невозможно создать объект типа port по описанию)
    MISTAKE_WITH_PORT_SETTINGS("Не удалось установить параметры COM-порта"),
    // Нет доступных COM-портов
    NO_AVAILABLE_PORTS("Нет доступных COM-портов"),

    PORT_IS_OPEN_MISTAKE("Не удалось установить открыт ли COM-порт"),

    //ArduinoService
    //Ошибка при чтении данных
    NO_AVAILABLE_READ_DATA("Не удалось прочитать данные"),
    //Ошибка при отправке данных
    NO_AVAILABLE_WRITE_DATA("Не удалось отправить данные"),
    //Ошибка при закрытии порта
    NO_AVAILABLE_CLOSE_PORT("Не удалось закрыть COM-порт"),
    //Порт открыт/используется
    PORT_IS_JUST_OPEN("COM-порт открыт/используется"),
    //Не удалось организовать запись/чтение данных порта
    NO_AVAILABLE_READ_WRITE_DATA("Невозможно организовать запись/чтение данных COM-порта"),
    //Не удалось открыть COM-порт для передачи данных
    NO_AVAILABLE_OPEN_PORT("Не удалось открыть COM-порт для передачи данных"),

    //ListenerDisconnected
    // "Соединение прервано";
    PORT_DISCONNECTED("Соединение прервано");

    private final String message;

    MESSAGES(String msg){
        message = msg;
    }

    public String getMessage() {
        return message;
    }
}
