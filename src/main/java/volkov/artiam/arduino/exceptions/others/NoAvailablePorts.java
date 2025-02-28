package volkov.artiam.arduino.exceptions.others;

import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.*;

public class NoAvailablePorts extends Exception {

    public NoAvailablePorts(){
        String message = MESSAGES.NO_AVAILABLE_PORTS.toString();
        JOptionPane.showMessageDialog(null, message);
    }
}
