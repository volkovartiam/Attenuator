package volkov.artiam.datas;

public enum TEXTs {

    // Включение
    ON("ВКЛ"),
    // Отключение
    OFF("ОТКЛ"),

    OK("OK"),
    RK("RK"),

    LED_ON("Контроль ВКЛ"),
    LED_OFF("Контроль ОТКЛ"),
    CONNECT("Подключение"),
    DISCONNECT("Отключение" );

    private final String text;

    TEXTs(String msg){
        text = msg;
    }

    public String getText() {
        return text;
    }
}
