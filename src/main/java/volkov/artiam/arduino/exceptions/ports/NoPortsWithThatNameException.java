package volkov.artiam.arduino.exceptions.ports;
import volkov.artiam.datas.MESSAGES;

import javax.swing.*;

public class NoPortsWithThatNameException extends Exception {

    public NoPortsWithThatNameException(){
        String message = MESSAGES.NO_PORTS_WITH_THAT_NAME.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
