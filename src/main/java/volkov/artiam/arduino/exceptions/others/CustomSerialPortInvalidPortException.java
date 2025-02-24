package volkov.artiam.arduino.exceptions.others;

import volkov.artiam.datas.MESSAGES;

import javax.swing.*;

public class CustomSerialPortInvalidPortException extends Exception{

    public CustomSerialPortInvalidPortException(){
        String message = MESSAGES.MISTAKE_WITH_PORT_SETTINGS.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
