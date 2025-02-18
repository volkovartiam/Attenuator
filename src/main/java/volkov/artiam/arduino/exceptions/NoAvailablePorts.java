package volkov.artiam.arduino.exceptions;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class NoAvailablePorts extends Exception {

    public NoAvailablePorts(){
        String message = Messages.NO_AVAILABLE_PORTS.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
