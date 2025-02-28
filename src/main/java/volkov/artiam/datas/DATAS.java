package volkov.artiam.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum DATAS {

    //Для отправки в ардуино
    LED_ON("LED;ON;"),
    LED_OFF("LED;OFF;"),

    GET_VERSION("GET;VERSION;"),

    NEG_3_3V_ON("NEG_3_3V;ON;"),
    NEG_3_3V_OFF("NEG_3_3V;OFF;"),

    POS_3_3V_ON("POS_3_3V;ON;"),
    POS_3_3V_OFF("POS_3_3V;OFF;"),

    ATT_AUTO_ON("POS_3_3V;ON;"),
    ATT_AUTO_OFF("POS_3_3V;ON;"),
    ATT("ATT;"),                    //COMMAND_ATT_ ATT = "ATT;31.5;" ;      //Пример

    CONNECT("CONNECT;"),
    DISCONNECT("CONNECT;"),
    UPDATE("UPDATE;"),

    //Для кнопок
    ON("ВКЛ"),
    OFF("ОТКЛ"),

    LED_ON_BUTTON("Контроль ВКЛ"),
    LED_OFF_BUTTON("Контроль ОТКЛ"),
    CONNECT_BUTTON("Подключение"),
    DISCONNECT_BUTTON("Отключение" ),

    //Для слушателя
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
