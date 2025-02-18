package volkov.artiam.arduino.exceptions;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class CustomSerialPortInvalidPortException extends Exception{

    public CustomSerialPortInvalidPortException(){
        String message = Messages.MISTAKE_WITH_PORT_SETTINGS.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
