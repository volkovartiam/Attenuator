package volkov.artiam.arduino.listeners;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.JOptionPane;

@Setter @Getter
public class Listener_Port_Disconnected  extends ArduinoListener implements SerialPortDataListener {

    boolean isDisconnected = false;

    public Listener_Port_Disconnected(){
        addDataListener(this);
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_PORT_DISCONNECTED;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if( event.getEventType() == SerialPort.LISTENING_EVENT_PORT_DISCONNECTED) {
            isDisconnected = true;
            printer.print("PORT_DISCONNECTED");
            JOptionPane.showMessageDialog(null, MESSAGES.PORT_DISCONNECTED.toString() );
        }
    }

}
