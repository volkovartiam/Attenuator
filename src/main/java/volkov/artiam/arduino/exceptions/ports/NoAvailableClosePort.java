package volkov.artiam.arduino.exceptions.ports;

import volkov.artiam.datas.MESSAGES;

import javax.swing.*;

public class NoAvailableClosePort extends Exception {

    public NoAvailableClosePort(){
        String message = MESSAGES.NO_AVAILABLE_CLOSE_PORT.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
