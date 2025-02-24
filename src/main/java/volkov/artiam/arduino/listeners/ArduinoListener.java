package volkov.artiam.arduino.listeners;

import com.fazecast.jSerialComm.SerialPortDataListener;
import volkov.artiam.arduino.ArduinoService;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

public class ArduinoListener {

    ArduinoService arduino;

    IPrinter printer = new ConsolePrinter();

    public ArduinoListener(){
        arduino = ArduinoService.getInstance();

    }

     protected void addDataListener(SerialPortDataListener listener){
        arduino.getPort().addDataListener(listener);
    }

}
