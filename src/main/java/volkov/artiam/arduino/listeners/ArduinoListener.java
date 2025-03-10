package volkov.artiam.arduino.listeners;

import com.fazecast.jSerialComm.SerialPortDataListener;
import volkov.artiam.arduino.ArduinoService;
import volkov.artiam.arduino.ArduinoServiceWithListeners;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;
import volkov.artiam.printers.NoPrinter;

public class ArduinoListener {

    ArduinoServiceWithListeners arduino;

    IPrinter printer = new NoPrinter();

    public ArduinoListener(){
        arduino = ArduinoServiceWithListeners.getInstance();

    }

     protected void addDataListener(SerialPortDataListener listener){
        arduino.getPort().addDataListener(listener);
    }

}
