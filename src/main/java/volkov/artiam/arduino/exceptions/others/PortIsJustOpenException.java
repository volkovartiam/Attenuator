package volkov.artiam.arduino.exceptions.others;

import volkov.artiam.datas.MESSAGES;

import javax.swing.*;

public class PortIsJustOpenException extends Exception {

    public PortIsJustOpenException(){
        String message = MESSAGES.PORT_IS_JUST_OPEN.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
