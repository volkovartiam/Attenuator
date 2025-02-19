package volkov.artiam.datas;

public enum TEXTs {

    // ���������
    ON("���"),
    // ����������
    OFF("����"),

    OK("OK"),
    RK("RK"),

    LED_ON("�������� ���"),
    LED_OFF("�������� ����"),
    CONNECT("�����������"),
    DISCONNECT("����������" );

    private final String text;

    TEXTs(String msg){
        text = msg;
    }

    public String getText() {
        return text;
    }
}
