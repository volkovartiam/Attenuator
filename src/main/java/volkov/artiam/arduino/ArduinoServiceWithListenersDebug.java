package volkov.artiam.arduino;

import volkov.artiam.arduino.exceptions.ports.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.ports.NoAvailableOpenPort;
import volkov.artiam.arduino.exceptions.ports.�heckIsOpenPortException;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.arduino.listeners.Listener_Port_Disconnected;
import volkov.artiam.datas.Additions;

import java.util.ArrayList;
import java.util.Arrays;

public class ArduinoServiceWithListenersDebug {

    public static void main(String[] args ) throws NoAvailableReadWriteData, NoAvailableWriteData, NoAvailableReadData,
            �heckIsOpenPortException, NoAvailableOpenPort, NoAvailableClosePort {

        ArduinoServiceWithLIsteners arduino = ArduinoServiceWithLIsteners.getInstance();
        ArduinoServiceWithLIsteners arduino2 = ArduinoServiceWithLIsteners.getInstance();;


        String[] portNames = arduino.getPortsNames();
        System.out.println( "������ ��������� ������: " +  new ArrayList<>(Arrays.asList(portNames) ));

        System.out.println("������� ���������� ���� �� �����: " + arduino.setPortByName("COM5"));

        System.out.println( "���� ������: " + arduino.isOpen() );
        System.out.println( "������� ������� ����: " + arduino.openPort() );
        System.out.println( "������� ������� ���� ��������: " + arduino.openPort() );

        System.out.println( "���� ������: " + arduino.isOpen() );
        System.out.println( "������������� ������/������: " + arduino.initReaderWriter() );

        System.out.println("�������� ArduinoService ��������� �1 " + arduino.getPort().getSystemPortName());
        System.out.println("�������� ArduinoService ��������� �2 " + arduino2.getPort().getSystemPortName());

        System.out.println( "���������������� ���������: ");

        /*
        // Only one listener can be registered at a time;
        // https://github.com/Fazecast/jSerialComm/issues/456?ysclid=m7ipecruoz480203933
        */

        arduino.initListener(new Listener_Port_Disconnected());
        //arduino.initListener(new Listener_Data_Written());
        //arduino.initListener(new Listener_Data_Received());
        //arduino.initListener(new Listener_Data_Available());

        /*
        Additions.waitMilliseconds(1000);
        int number = 5;
        for (int i = 0; i < number; i++){
            System.out.println(i);
        }
        */
        /**/
        Additions.waitMilliseconds();
        int newNumber = 5;
        for (int i = 0; i < newNumber; i++){
            arduino.sendCommand("LED;ON;");
            Additions.waitMilliseconds();
            /*
            Additions.waitMilliseconds(2000);
            arduino.sendCommand("LED;OFF;");
            Additions.waitMilliseconds(2000); */
            System.out.println(arduino.readData() );
        }
        /**/

        System.out.println( "���� ������: " + arduino.closePort() );
        System.out.println( "End of program");

    }
}
