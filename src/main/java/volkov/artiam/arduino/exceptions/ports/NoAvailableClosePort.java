package volkov.artiam.arduino.exceptions.ports;

import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.*;

public class NoAvailableClosePort extends Exception {

    public NoAvailableClosePort(){
        String message = MESSAGES.NO_AVAILABLE_CLOSE_PORT.toString();
        JOptionPane.showMessageDialog(null, message);
    }
}
