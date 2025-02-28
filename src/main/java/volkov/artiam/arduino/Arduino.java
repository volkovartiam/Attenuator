package volkov.artiam.arduino;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;
import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.ports.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.ports.NoAvailableOpenPort;
import volkov.artiam.arduino.exceptions.ports.NoPortsWithThatNameException;
import volkov.artiam.arduino.exceptions.ports.�heckIsOpenPortException;

import java.util.Arrays;

@Getter @Setter
public class Arduino  {

    private int baudRate = 9600;
    SerialPort port;
    private String portName;
    private SerialPort[] ports;
    private String[] portsNames;
    private String[] portsNamesByDefault = {""};

    private static Arduino instance;

    public static Arduino getInstance(){
        if(instance == null) {
            instance = new Arduino();
        }
        return instance;
    }

    Arduino() {
        portsNames = getPortsNames();
    }


    public boolean isOpen() throws �heckIsOpenPortException {
        try {
            return port.isOpen();
        } catch (Exception e) {
            throw new �heckIsOpenPortException();
        }
    }


    public boolean closePort() throws NoAvailableClosePort {
        try {
            return port.closePort();
        } catch (Exception e) {
            throw new NoAvailableClosePort();
        }
    }


    public boolean openPort() throws NoAvailableOpenPort {
        try {
            return port.openPort();
        } catch (Exception e) {
            throw new NoAvailableOpenPort();
        }
    }


    public boolean setPortByName(String portName) {
        boolean portParametersIsSet;
        try {
            if( checkName(portName) ) {
                port = SerialPort.getCommPort(portName);
                port.setBaudRate(baudRate);
                portParametersIsSet = true;
            } else {
                throw new NoPortsWithThatNameException();
            }
        } catch (SerialPortInvalidPortException e) {
            portParametersIsSet = false;
        } catch (NoPortsWithThatNameException e) {
            portParametersIsSet = false;
        }
        return portParametersIsSet;
    }


    // ������ ��������� ���� COM-������
    public String[] getPortsNames() {
        try {
            ports = SerialPort.getCommPorts();
            portsNames = Arrays.stream(Arrays.stream(ports)
                    .filter( x -> {
                        String serialPort = "���������������� ����";            //������������ � COM-������ �������� �� ������ ������������
                        return !x.getPortDescription().contains(serialPort);
                    })
                    .toArray(SerialPort[]::new))
                    .map( x -> x.getSystemPortName())
                    .sorted()
                    .toArray(String[]::new);
            if(portsNames.length == 0 ) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e ) {
            portsNames = portsNamesByDefault;
        }
        return portsNames;
    }


    private boolean checkName(String portName){
        boolean isPortInList = Arrays.asList(portsNames).contains(portName);        // ���� ��� ����� � ������
        boolean isReadableName = !portName.equals("User-Specified Port");           // ���� ��������� ����� ����������� ��� �����, �������� �� "[][][]"
        boolean isPortsHere = !portName.equals("");                                 // ���� ���� ����
        boolean isChecked = (isPortInList && isReadableName && isPortsHere);
        return isChecked;
    }

}