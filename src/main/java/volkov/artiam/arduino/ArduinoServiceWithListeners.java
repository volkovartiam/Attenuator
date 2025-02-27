package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.ports.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.ports.NoAvailableOpenPort;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.datas.COMMANDS;
import volkov.artiam.printers.IPrinter;

@Setter @Getter
public class ArduinoServiceWithListeners extends ArduinoService implements IPrinter{

    private static ArduinoServiceWithListeners instance;

    boolean isConnected = false;

    public static ArduinoServiceWithListeners getInstance(){
        if(instance == null) {
            instance = new ArduinoServiceWithListeners();
        }
        return instance;
    }


    @Override
    public void print(Object command) {
        if(command.equals(COMMANDS.UPDATE)){
            //this.getPortsNames();
        }
        if(command.equals(COMMANDS.CONNECT)){
           //this.openPort();
        }
        if(command.equals(COMMANDS.DISCONNECT)) {
            //this.closePort();
        }

        /*
        if(command.equals(COMMANDS.LED_ON)) {
            this.sendCommand(COMMANDS.LED_ON);
        }*/

        try {
            this.sendCommand(command.toString() );
        } catch (NoAvailableWriteData e) {
            e.printStackTrace();
        }

        this.getPrinter().print(command);
    }

    public boolean closePort(){
        boolean isClose = false;
        try {
            isClose = super.closePort();
        } catch (NoAvailableClosePort e) {
            isClose = false;
            e.printStackTrace();
        }
        if(isClose) {
            isConnected = false;
        }
        return isClose;
    }


    public boolean openPort(){
        boolean isOpen = false;
        boolean isInit = false;
        try {
            isInit = initReaderWriter();
        } catch (NoAvailableReadWriteData e) {
            isInit = false;
            e.printStackTrace();
        }
        try {
            isOpen = super.openPort() & isInit;
        } catch (NoAvailableOpenPort e) {
            isOpen = false;
            e.printStackTrace();
        }
        if(isOpen) {
            isConnected = true;
        }
        return isOpen;
    }


    /*
    private void sendCommand(Object obj) {
        String command = obj.toString();
        System.out.println("command = " + command);
        try {
            super.sendCommand(command);
        } catch (NoAvailableWriteData e) {
            e.printStackTrace();
            this.getPrinter().print("HERE IS EXCEPTION");
        }
    }
        */

}