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
        System.out.println( "������ ��������� ������: " +  new ArrayList<>(Arrays.asList(portNames) ));

        arduino.setPortByName("COM5");

        System.out.println( "���� ������: " + arduino.isOpen() );
        System.out.println( "������� ������� ����: " + arduino.openPort() );
        System.out.println( "������� ������� ���� ��������: " + arduino.openPort() );

        System.out.println( "���� ������: " + arduino.isOpen() );


        try {
            System.out.println("Time to sleep");
            Thread.sleep(5000);
            System.out.println("Time to wake up");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
