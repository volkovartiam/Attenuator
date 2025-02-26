package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.COMMANDS;
import volkov.artiam.printers.IPrinter;

@Setter @Getter
public class ArduinoServiceWithListeners extends ArduinoService implements IPrinter{

    private static ArduinoServiceWithListeners instance;

    public static ArduinoServiceWithListeners getInstance(){
        if(instance == null) {
            instance = new ArduinoServiceWithListeners();
        }
        return instance;
    }


    @Override
    public void print(Object object) {
        if(object.equals(COMMANDS.UPDATE)){

            System.out.println(object + "+++");
        }
        getPrinter().print(object);
    }




}