package volkov.artiam.arduino.exceptions.ports;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class NoAvailableOpenPort extends Exception {

    public NoAvailableOpenPort(){
        String message = Messages.NO_AVAILABLE_OPEN_PORT.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
