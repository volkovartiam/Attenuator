package volkov.artiam.arduino.exceptions;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class PortIsJustOpenException extends Exception {

    public PortIsJustOpenException(){
        String message = Messages.PORT_IS_JUST_OPEN.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
