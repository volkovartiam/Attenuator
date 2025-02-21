package volkov.artiam.arduino;

import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.datas.Additions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArduinoServiceDebug {

    public static void main(String[] args ) throws NoAvailableReadWriteData, NoAvailableWriteData, NoAvailableReadData {

        ArduinoService arduino = new ArduinoService();

        String[] portNames = arduino.getPortsNames();
        System.out.println( "������ ��������� ������: " +  new ArrayList<>(Arrays.asList(portNames) ));

        arduino.setPortByName("COM5");

        System.out.println( "���� ������: " + arduino.isOpen() );
        System.out.println( "������� ������� ����: " + arduino.openPort() );
        System.out.println( "������� ������� ���� ��������: " + arduino.openPort() );

        System.out.println( "���� ������: " + arduino.isOpen() );
        System.out.println( "������������� ������/������: " + arduino.initReaderWriter() );

        Additions.waitMilliseconds();

        int number = 5;
        for (int i = 0; i < number; i++){
            arduino.sendCommand("LED;ON;");
            Additions.waitMilliseconds();
            System.out.println(arduino.readData() );
        }


    }
}
