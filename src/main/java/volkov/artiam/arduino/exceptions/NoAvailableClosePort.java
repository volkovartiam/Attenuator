package volkov.artiam.arduino.exceptions;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class NoAvailableClosePort extends Exception {

    public NoAvailableClosePort(){
        String message = Messages.NO_AVAILABLE_CLOSE_PORT.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
