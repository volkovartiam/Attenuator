package volkov.artiam.arduino.exceptions.ports;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class �heckIsOpenPortException extends Exception {

    public �heckIsOpenPortException(){
        String message = Messages.PORT_IS_OPEN_MISTAKE.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
