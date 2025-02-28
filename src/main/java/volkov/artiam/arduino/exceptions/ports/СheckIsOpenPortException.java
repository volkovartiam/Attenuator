package volkov.artiam.arduino.exceptions.ports;

import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.*;

public class ÑheckIsOpenPortException extends Exception {

    public ÑheckIsOpenPortException(){
        String message = MESSAGES.PORT_IS_OPEN_MISTAKE.toString();
        JOptionPane.showMessageDialog(null, message);
    }
}
