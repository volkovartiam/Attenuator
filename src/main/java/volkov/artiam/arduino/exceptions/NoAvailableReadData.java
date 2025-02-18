package volkov.artiam.arduino.exceptions;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class NoAvailableReadData extends Exception {

    public NoAvailableReadData(){
        String message = Messages.NO_AVAILABLE_READ_DATA.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
