package volkov.artiam.arduino.listeners;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Setter @Getter
public class Listener_Data_Available extends ArduinoListener implements SerialPortDataListener {

    boolean isDataAvailable = false;

    public Listener_Data_Available(){
        addDataListener(this);
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if( event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
            isDataAvailable = true;
            arduino.readData();
            //printer.print("DATA_AVAILABLE");
            //JOptionPane.showMessageDialog(null, "Доступны данные для чтения" );
        }
    }

}
