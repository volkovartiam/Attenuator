package volkov.artiam.arduino;

import volkov.artiam.arduino.exceptions.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.NoPortsWithThatNameException;
import volkov.artiam.arduino.exceptions.PortIsOpenMistakeException;

import java.util.ArrayList;
import java.util.Arrays;

public class ArduinoDebug {

    public static void main(String[] args ) throws PortIsOpenMistakeException, NoPortsWithThatNameException, NoAvailableClosePort {

        Arduino arduino = new Arduino();

        String[] portNames = arduino.getAvailblePortsNames();
        System.out.println( "Список доступных портов: " +  new ArrayList<>(Arrays.asList(portNames) ));

        arduino.setPortByName("COM5");

        System.out.println( "Порт открыт: " + arduino.isOpen() );
        System.out.println( "Попытка открыть порт: " + arduino.port.openPort() );
        System.out.println( "Порт открыт: " + arduino.isOpen() );

        //Записываем в порт
        byte [] array = {1 , 2};
        arduino.port.writeBytes( array, 2);

        System.out.println( "Порт закрыт: " + arduino.closePort() );

    }

}
