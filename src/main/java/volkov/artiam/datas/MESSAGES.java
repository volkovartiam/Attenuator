package volkov.artiam.datas;

public enum MESSAGES {

    //Arduino
    // ��� ������� ������ ��������� ��� ���� ���� �����������
    NO_PORTS_WITH_THAT_NAME("COM-���� � ����� ������ �����������"),
    // Unable to create a serial port object from the invalid port descriptor
    // ��� ������ SerialPortInvalidPortException (���������� ������� ������ ���� port �� ��������)
    MISTAKE_WITH_PORT_SETTINGS("�� ������� ���������� ��������� COM-�����"),
    // ��� ��������� COM-������
    NO_AVAILABLE_PORTS("��� ��������� COM-������"),

    PORT_IS_OPEN_MISTAKE("�� ������� ���������� ������ �� COM-����"),

    //ArduinoService
    //������ ��� ������ ������
    NO_AVAILABLE_READ_DATA("�� ������� ��������� ������"),
    //������ ��� �������� ������
    NO_AVAILABLE_WRITE_DATA("�� ������� ��������� ������"),
    //������ ��� �������� �����
    NO_AVAILABLE_CLOSE_PORT("�� ������� ������� COM-����"),
    //���� ������/������������
    PORT_IS_JUST_OPEN("COM-���� ������/������������"),
    //�� ������� ������������ ������/������ ������ �����
    NO_AVAILABLE_READ_WRITE_DATA("���������� ������������ ������/������ ������ COM-�����"),
    //�� ������� ������� COM-���� ��� �������� ������
    NO_AVAILABLE_OPEN_PORT("�� ������� ������� COM-���� ��� �������� ������"),

    //ListenerDisconnected
    // "���������� ��������";
    PORT_DISCONNECTED("���������� ��������");

    private final String message;

    MESSAGES(String msg){
        message = msg;
    }

    public String getMessage() {
        return message;
    }
}
