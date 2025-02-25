package volkov.artiam.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum COMMANDS {

    COMMAND_LED_ON("LED;ON;"),
    COMMAND_LED_OFF("LED;OFF;"),

    COMMAND_VERSION_GED("GET;VERSION;"),

    COMMAND_NEG_3_3V_ON("NEG_3_3V;ON;"),
    COMMAND_NEG_3_3V_OFF("NEG_3_3V;OFF;"),

    COMMAND_POS_3_3V_ON("POS_3_3V;ON;"),
    COMMAND_POS_3_3V_OFF("POS_3_3V;OFF;"),

    COMMAND_ATT_AUTO_ON("POS_3_3V;ON;"),
    COMMAND_ATT_AUTO_OFF("POS_3_3V;ON;");
    //COMMAND_ATT_ ATT = "ATT;" ;

    final String command;

    public static String[] getCommands(){
        return Arrays.stream(COMMANDS.values())
                .map(COMMANDS::getCommand)
                .toArray(String[]::new);
    }

}
