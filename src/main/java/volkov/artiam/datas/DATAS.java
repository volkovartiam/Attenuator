package volkov.artiam.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum DATAS {

    //��� �������� � �������
    LED_ON("LED;ON;"),
    LED_OFF("LED;OFF;"),

    GET_VERSION("GET;VERSION;"),

    NEG_3_3V_ON("NEG_3_3V;ON;"),
    NEG_3_3V_OFF("NEG_3_3V;OFF;"),

    POS_3_3V_ON("POS_3_3V;ON;"),
    POS_3_3V_OFF("POS_3_3V;OFF;"),

    ATT_AUTO_ON("ATT_AUTO;ON;"),
    ATT_AUTO_OFF("ATT_AUTO;OFF;"),
    ATT("ATT;"),                    //��������� �������� ����������      //������ "ATT;31.5;" ;     (0.0 ... 31.5)

    TM_ATT("TM_ATT;") ,             //��������� �������� ����������      //������ "TM_ATT;0;" ;     (0 ... 63)
    TM_ATT_Postfix(";") ,

    CONNECT("CONNECT;"),
    DISCONNECT("CONNECT;"),
    UPDATE("UPDATE;"),

    //��� ������
    ON("���"),
    OFF("����"),

    LED_ON_BUTTON("�������� ���"),
    LED_OFF_BUTTON("�������� ����"),
    CONNECT_BUTTON("�����������"),
    DISCONNECT_BUTTON("����������" ),

    //��� ���������
    PCL_COMMAND("command"),
    PCL_NEWS("news"),
    PCL_TM("tm");

    final String datas;

    public static String[] getAllDatas(){
        return Arrays.stream(DATAS.values())
                .map(DATAS::getDatas)
                .toArray(String[]::new);
    }

    @Override
    public String toString() {
        return datas;
    }
}
