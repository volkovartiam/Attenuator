package volkov.artiam.arduino;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;
import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.ports.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.ports.NoAvailableOpenPort;
import volkov.artiam.arduino.exceptions.ports.NoPortsWithThatNameException;
import volkov.artiam.arduino.exceptions.ports.СheckIsOpenPortException;

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


    public boolean isOpen() throws СheckIsOpenPortException {
        try {
            return port.isOpen();
        } catch (Exception e) {
            throw new СheckIsOpenPortException();
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


    // Массив доступных имен COM-портов
    public String[] getPortsNames() {
        try {
            ports = SerialPort.getCommPorts();
            portsNames = Arrays.stream(Arrays.stream(ports)
                    .filter( x -> {
                        String serialPort = "Последовательный порт";            //Подключенные к COM-портам мониторы не должны отображаться
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
        boolean isPortInList = Arrays.asList(portsNames).contains(portName);        // Если имя порта в списке
        boolean isReadableName = !portName.equals("User-Specified Port");           // Если программа может прочитатать имя порта, например не "[][][]"
        boolean isPortsHere = !portName.equals("");                                 // Если порт есть
        boolean isChecked = (isPortInList && isReadableName && isPortsHere);
        return isChecked;
    }

}