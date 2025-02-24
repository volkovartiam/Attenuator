package volkov.artiam.arduino.listeners;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import volkov.artiam.arduino.ArduinoService;

public class Listener_Data_Received extends ArduinoListener implements SerialPortDataListener {

    boolean isReceived = false;

    public Listener_Data_Received(){
        addDataListener(this);
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED ;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if( event.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
            isReceived = true;
            printer.print("DATA_RECEIVED");
        }
    }

}
