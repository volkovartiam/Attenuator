package volkov.artiam.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum COMMANDS {

    LED_ON("LED;ON;"),
    LED_OFF("LED;OFF;"),

    GET_VERSION("GET;VERSION;"),

    NEG_3_3V_ON("NEG_3_3V;ON;"),
    NEG_3_3V_OFF("NEG_3_3V;OFF;"),

    POS_3_3V_ON("POS_3_3V;ON;"),
    POS_3_3V_OFF("POS_3_3V;OFF;"),

    ATT_AUTO_ON("POS_3_3V;ON;"),
    ATT_AUTO_OFF("POS_3_3V;ON;"),
    ATT("ATT;"),
    //COMMAND_ATT_ ATT = "ATT;31.5;" ;      //Пример

    CONNECT("CONNECT;"),
    DISCONNECT("DISCONNECT;"),
    UPDATE("UPDATE;");

    final String command;

    public static String[] getCommands(){
        return Arrays.stream(COMMANDS.values())
                .map(COMMANDS::getCommand)
                .toArray(String[]::new);
    }

    @Override
    public String toString() {
        return command;
    }
}
