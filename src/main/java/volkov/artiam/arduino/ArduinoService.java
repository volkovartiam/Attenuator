package volkov.artiam.arduino;

import com.fazecast.jSerialComm.SerialPortDataListener;
import lombok.Getter;
import lombok.Setter;

import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Setter @Getter
public class ArduinoService extends Arduino{

    private static PrintWriter outPut;
    private static BufferedInputStream inPut;

    private IPrinter printer = new ConsolePrinter();

    private static ArduinoService instance;


    public static ArduinoService getInstance(){
        if(instance == null) {
            instance = new ArduinoService();
        }
        return instance;
    }

    void initListener(SerialPortDataListener defaultSerialPortDataListener) {
        port.addDataListener(defaultSerialPortDataListener);
    }

    public boolean initReaderWriter() throws NoAvailableReadWriteData {
        boolean isInitReaderWriter = false;
        try {
            outPut = new PrintWriter(port.getOutputStream(), true, StandardCharsets.UTF_8);
            inPut = new BufferedInputStream(port.getInputStream() );
            isInitReaderWriter = true;
        }catch (Exception e){
            isInitReaderWriter = false;
            throw new NoAvailableReadWriteData();
        }
        return isInitReaderWriter;
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