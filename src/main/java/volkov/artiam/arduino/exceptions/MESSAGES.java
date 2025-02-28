package volkov.artiam.arduino.exceptions;

public enum MESSAGES {

    NO_PORTS_WITH_THAT_NAME("COM-порт с таким именем отсутствует"),
    MISTAKE_WITH_PORT_SETTINGS("Не удалось установить параметры COM-порта"),
    NO_AVAILABLE_PORTS("Нет доступных COM-портов"),
    PORT_IS_OPEN_MISTAKE("Не удалось установить открыт ли COM-порт"),

    NO_AVAILABLE_READ_DATA("Не удалось прочитать данные"),
    NO_AVAILABLE_WRITE_DATA("Не удалось отправить данные"),
    NO_AVAILABLE_CLOSE_PORT("Не удалось закрыть COM-порт"),

    PORT_IS_JUST_OPEN("COM-порт открыт/используется"),
    NO_AVAILABLE_READ_WRITE_DATA("Невозможно организовать запись/чтение данных COM-порта"),
    NO_AVAILABLE_OPEN_PORT("Не удалось открыть COM-порт для передачи данных"),

    PORT_DISCONNECTED("Соединение прервано");

    private final String message;

    MESSAGES(String message){
        this.message = message;
    }

    @Override
    public String toString() {return message;}

}
