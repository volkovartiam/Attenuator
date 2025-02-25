package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

@Setter @Getter
public class ArduinoServiceWithLIsteners extends ArduinoService {

    private IPrinter printer = new ConsolePrinter();

    private static ArduinoServiceWithLIsteners instance;

    public static ArduinoServiceWithLIsteners getInstance(){
        if(instance == null) {
            instance = new ArduinoServiceWithLIsteners();
        }
        return instance;
    }



}