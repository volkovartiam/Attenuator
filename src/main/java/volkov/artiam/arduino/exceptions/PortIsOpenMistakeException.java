package volkov.artiam.arduino.exceptions;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class PortIsOpenMistakeException extends Exception {

    public PortIsOpenMistakeException(){
        String message = Messages.PORT_IS_OPEN_MISTAKE.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
