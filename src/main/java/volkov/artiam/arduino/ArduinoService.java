package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.*;
import volkov.artiam.arduino.listeners.ListenerDisconnected;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Setter @Getter
public class ArduinoService {

    private Arduino arduino = new Arduino();
    private static PrintWriter outPut;
    private static BufferedInputStream inPut;

    private ListenerDisconnected listenerDisconnected = new ListenerDisconnected();

    void initOutputAndInput() throws NoAvailableReadWriteData {
        try {
            outPut = new PrintWriter(arduino.port.getOutputStream(), true, StandardCharsets.UTF_8);
            inPut = new BufferedInputStream( arduino.port.getInputStream() );
        }catch (Exception e){
            throw new NoAvailableReadWriteData();
        }
    }

    public String[] getAvailablePortsNames() {
        return arduino.getAvailblePortsNames();
    }

    public boolean setPortByName(String portName) {
        boolean portByNameSet;
        try {
            portByNameSet = arduino.setPortByName(portName);
        } catch (NoPortsWithThatNameException e){
            portByNameSet = false;
        }
        return portByNameSet;
   }

    public boolean openPort() {
        boolean portIsOpened;
        try{
            if(!arduino.isOpen() ) {
                if(arduino.openPort() ) {
                    listenerDisconnected = new ListenerDisconnected(arduino);
                    portIsOpened = true;
                } else {
                    throw new NoAvailableOpenPort();
                }
            } else {
                throw new PortIsJustOpenException();
            }
        } catch (PortIsOpenMistakeException e){
            portIsOpened = false;
        } catch (NoAvailableOpenPort e){
            portIsOpened = false;
        } catch (PortIsJustOpenException e){
            portIsOpened = false;
        }
        return portIsOpened;
    }

    public boolean isOpened(){
        boolean portIsOpen;
        try {
            portIsOpen = arduino.isOpen();
        } catch (PortIsOpenMistakeException e) {
            portIsOpen = false;
        }
        return portIsOpen;
    }


    public boolean closePort()  {
        boolean portIsClose;
        try {
            if(arduino.isOpen() ) {
                portIsClose = arduino.closePort();
            } else {
                throw new NoAvailableClosePort();
            }
        }catch (PortIsOpenMistakeException e){
            portIsClose = false;
        }catch (NoAvailableClosePort e){
            portIsClose = false;
        }
        return portIsClose;
    }


    public void sendData(String command) throws NoAvailableWriteData {
        try {
            if( !command.isEmpty() && !command.isBlank() ){
                outPut.println(command) ;
                System.out.println(command);
                outPut.flush();
            }
        } catch (Exception e){
            throw new NoAvailableWriteData();
        }
    }


    public String readData() throws NoAvailableReadData {
        StringBuilder line = new StringBuilder();
        String data;
        try{
            while(inPut.available() > 0 ){
                int value = inPut.read();
                String ascii = Character.toString(value);
                line.append(ascii);
            }
            data = line.toString();
        }catch (IOException e ){
            data = "";
        }
        return data;
    }

    public boolean isDisconnected(){
        return listenerDisconnected.isDisconnected();
    }

}