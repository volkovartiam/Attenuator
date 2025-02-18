package volkov.artiam.arduino;

import volkov.artiam.arduino.exceptions.NoPortsWithThatNameException;
import volkov.artiam.arduino.exceptions.PortIsOpenMistakeException;

public class ArduinoDebug {

    public static void main(String[] args ) throws PortIsOpenMistakeException, NoPortsWithThatNameException {

        Arduino arduino = new Arduino();

        String[] portNames = arduino.getAvailblePortsNames();
        for (String name : portNames ) {
            System.out.println( name );
        }

        arduino.setPortByName("COM5");

        System.out.println( arduino.portIsOpen() );
        System.out.println( arduino.port.openPort() );
        System.out.println( arduino.portIsOpen() );

        byte [] array = {1 , 2};
        arduino.port.writeBytes( array, 2);
    }

}
