package volkov.artiam.arduino;

import volkov.artiam.arduino.exceptions.ports.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.ports.NoAvailableOpenPort;
import volkov.artiam.arduino.exceptions.ports.NoPortsWithThatNameException;
import volkov.artiam.arduino.exceptions.ports.�heckIsOpenPortException;

import java.util.ArrayList;
import java.util.Arrays;

public class ArduinoDebug {

    public static void main(String[] args ) throws �heckIsOpenPortException, NoPortsWithThatNameException, NoAvailableClosePort, NoAvailableOpenPort {

        Arduino arduino = Arduino.getInstance();

        String[] portNames = arduino.getPortsNames();
        System.out.println( "������ ��������� ������: " +  new ArrayList<>(Arrays.asList(portNames) ));

        arduino.setPortByName("COM5");

        System.out.println( "���� ������: " + arduino.isOpen() );
        System.out.println( "������� ������� ����: " + arduino.openPort() );
        System.out.println( "������� ������� ���� ��������: " + arduino.openPort() );

        System.out.println( "���� ������: " + arduino.isOpen() );

        //���������� � ����
        byte [] array = {1 , 2};
        arduino.port.writeBytes( array, 2);


        try {
            System.out.println("Time to sleep");
            Thread.sleep(1000);
            System.out.println("Time to wake up");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println( "���� ������: " + arduino.port.isOpen() );
        System.out.println( "���� ������: " + arduino.closePort() );

    }

}
