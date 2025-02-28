package volkov.artiam.arduino.exceptions;

public enum MESSAGES {

    NO_PORTS_WITH_THAT_NAME("COM-���� � ����� ������ �����������"),
    MISTAKE_WITH_PORT_SETTINGS("�� ������� ���������� ��������� COM-�����"),
    NO_AVAILABLE_PORTS("��� ��������� COM-������"),
    PORT_IS_OPEN_MISTAKE("�� ������� ���������� ������ �� COM-����"),

    NO_AVAILABLE_READ_DATA("�� ������� ��������� ������"),
    NO_AVAILABLE_WRITE_DATA("�� ������� ��������� ������"),
    NO_AVAILABLE_CLOSE_PORT("�� ������� ������� COM-����"),

    PORT_IS_JUST_OPEN("COM-���� ������/������������"),
    NO_AVAILABLE_READ_WRITE_DATA("���������� ������������ ������/������ ������ COM-�����"),
    NO_AVAILABLE_OPEN_PORT("�� ������� ������� COM-���� ��� �������� ������"),

    PORT_DISCONNECTED("���������� ��������");

    private final String message;

    MESSAGES(String message){
        this.message = message;
    }

    @Override
    public String toString() {return message;}

}
