package volkov.artiam.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum COMMANDS {

    C0_LED_ON("LED;ON;"),
    C1_LED_OFF("LED;OFF;");

    final String command;

    public static String[] getCommands(){
        return Arrays.stream(COMMANDS.values())
                .map(COMMANDS::getCommand)
                .toArray(String[]::new);
    }

}
