package volkov.artiam.arduino.exceptions.others;

import volkov.artiam.datas.MESSAGES;

import javax.swing.*;

public class NoAvailablePorts extends Exception {

    public NoAvailablePorts(){
        String message = MESSAGES.NO_AVAILABLE_PORTS.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
