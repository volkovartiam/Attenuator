package volkov.artiam.arduino.listeners;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class Listener_Data_Written extends ArduinoListener implements SerialPortDataListener {

    public Listener_Data_Written(){
        addDataListener(this);
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_WRITTEN ;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if( event.getEventType() == SerialPort.LISTENING_EVENT_DATA_WRITTEN) {
            printer.print("DATA_WRITTEN");
        }
    }

}
