package volkov.artiam.arduino;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;
import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.*;

import java.util.Arrays;

@Getter @Setter
public class Arduino  {

    private int baudRate = 9600;
    SerialPort port;
    private String portName;
    private SerialPort[] ports;
    private String[] portsNames;

    public Arduino() {
        portsNames = getAvailblePortsNames();
    }

    boolean isOpen() throws PortIsOpenMistakeException {
        try {
            return port.isOpen();
        } catch (Exception e) {
            throw new PortIsOpenMistakeException();
        }
    }


    boolean closePort() throws NoAvailableClosePort {
        try {
            return port.closePort();
        } catch (Exception e) {
            throw new NoAvailableClosePort();
        }
    }

    boolean openPort() throws NoAvailableOpenPort {
        try {
            return port.openPort();
        } catch (Exception e) {
            throw new NoAvailableOpenPort();
        }
    }


    boolean setPortByName(String portName) throws NoPortsWithThatNameException{
        boolean portParamsSetted = false;
        try {
            if( checkName(portName) ) {
                port = SerialPort.getCommPort(portName);
                port.setBaudRate(baudRate);
                portParamsSetted = true;
            } else {
                throw new NoPortsWithThatNameException();
            }
        } catch (SerialPortInvalidPortException e) {
            portParamsSetted = false;
        }
        return portParamsSetted;
    }

    // Массив доступных имен COM-портов
    public String[] getAvailblePortsNames() {
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
            portsNames = new String[1];
            portsNames[0] = "";
        }
        return portsNames;
    }


    private boolean checkName(String portName){
        boolean isPortInList = Arrays.asList(portsNames).contains(portName);        // Если имя порта в списке
        boolean isReadableName = !portName.equals("User-Specified Port");           // Если программа может прочитатать имя порта, например не "[][][]"
        boolean isPortsHere = !portName.equals("");                                 // Если порт есть
        return (isPortInList && isReadableName && isPortsHere);
    }

}