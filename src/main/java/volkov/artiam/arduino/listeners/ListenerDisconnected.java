package volkov.artiam.arduino.listeners;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.Messages;
import volkov.artiam.arduino.Arduino;

import javax.swing.JOptionPane;

@Setter @Getter
public class ListenerDisconnected implements SerialPortDataListener {

    Arduino arduino;
    boolean isDisconnected = false;

    public ListenerDisconnected(){
    }

    public ListenerDisconnected(Arduino arduino){
        setArduino(arduino);
        arduino.getPort().addDataListener(this);
    }

    @Override
    public int getListeningEvents() {
        return this.arduino.getPort().LISTENING_EVENT_PORT_DISCONNECTED;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if( event.getEventType() == SerialPort.LISTENING_EVENT_PORT_DISCONNECTED) {
            isDisconnected = true;
            arduino.getPort().closePort();
            arduino.getPort().removeDataListener();

            String message = Messages.PORT_DISCONNECTED.getMessage();
            JOptionPane.showMessageDialog(null, message);
        }
    }

}
