package volkov.artiam.arduino.exceptions.others;

import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.*;

public class PortIsJustOpenException extends Exception {

    public PortIsJustOpenException(){
        String message = MESSAGES.PORT_IS_JUST_OPEN.toString();
        JOptionPane.showMessageDialog(null, message);
    }
}
