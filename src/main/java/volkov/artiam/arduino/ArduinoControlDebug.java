package volkov.artiam.arduino;

import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.datas.Additions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArduinoControlDebug {

    public static void main(String[] args ) throws IOException, NoAvailableWriteData, NoAvailableReadData {

        ArduinoControl arduino = new ArduinoControl();

        String[] portNames = arduino.getPortsNames();
        System.out.println( "Список доступных портов: " +  new ArrayList<>(Arrays.asList(portNames) ));

        arduino.setPortByName("COM5");

        System.out.println( "Порт открыт: " + arduino.isOpen() );
        System.out.println( "Попытка открыть порт: " + arduino.openPort() );
        System.out.println( "Попытка открыть порт повторно: " + arduino.openPort() );

        System.out.println( "Порт открыт: " + arduino.isOpen() );


        try {
            System.out.println("Time to sleep");
            Thread.sleep(5000);
            System.out.println("Time to wake up");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
