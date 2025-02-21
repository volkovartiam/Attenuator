package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;

import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.ports.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.ports.NoAvailableOpenPort;
import volkov.artiam.arduino.exceptions.ports.—heckIsOpenPortException;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Setter @Getter
public class ArduinoService {

    Arduino arduino;
    private static PrintWriter outPut;
    private static BufferedInputStream inPut;

    private boolean isInitReaderWriter = false;
    IPrinter printer = new ConsolePrinter();

    ArduinoService(){
        arduino = Arduino.getInstance();
    }

    boolean initReaderWriter() throws NoAvailableReadWriteData {
        try {
            outPut = new PrintWriter(arduino.port.getOutputStream(), true, StandardCharsets.UTF_8);
            inPut = new BufferedInputStream( arduino.port.getInputStream() );
            isInitReaderWriter = true;
        }catch (Exception e){
            throw new NoAvailableReadWriteData();
        }
        return isInitReaderWriter;
    }

    public boolean setPortByName(String name){
        return arduino.setPortByName(name);
    }

    public String[] getPortsNames(){
        return arduino.getPortsNames();
    }

    public boolean isOpen(){
        boolean isOpen;
        try {
            isOpen = arduino.isOpen();
        } catch (—heckIsOpenPortException e) {
            isOpen = false;
        }
        return isOpen;
    }


    public boolean openPort() {
        boolean isOpen;
        try{
            isOpen = arduino.openPort();
        } catch (NoAvailableOpenPort e){
            isOpen = false;
        }
        return isOpen;
    }


    public boolean closePort()  {
        boolean isClosed;
        try {
            if(isOpen() ) {
                isClosed = arduino.closePort();
            } else {
                throw new NoAvailableClosePort();
            }
        }catch (NoAvailableClosePort e){
            isClosed = false;
        }
        return isClosed;
    }


    public void sendCommand(String command) throws NoAvailableWriteData {
        try {
            if( !command.isEmpty() && !command.isBlank() ){
                outPut.println(command) ;
                printer.print(command);
                outPut.flush();
            }
        } catch (Exception e){
            throw new NoAvailableWriteData();
        }
    }


    public String readData() throws NoAvailableReadData {
        StringBuilder line = new StringBuilder();
        String data = "";
        try{
            while(inPut.available() > 0 ){
                int value = inPut.read();
                String ascii = Character.toString(value);
                line.append(ascii);
            }
            data = line.toString();
            printer.print(data);
        }catch (IOException e ){
            throw new NoAvailableReadData(data);
        }
        return data;
    }


}