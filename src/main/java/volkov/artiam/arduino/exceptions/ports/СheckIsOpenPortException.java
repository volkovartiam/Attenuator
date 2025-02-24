package volkov.artiam.arduino.exceptions.ports;

import volkov.artiam.datas.MESSAGES;

import javax.swing.*;

public class ÑheckIsOpenPortException extends Exception {

    public ÑheckIsOpenPortException(){
        String message = MESSAGES.PORT_IS_OPEN_MISTAKE.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
