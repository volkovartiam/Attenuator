package volkov.artiam.arduino.exceptions.streams;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class NoAvailableReadWriteData extends Exception {

    public NoAvailableReadWriteData(){
        String message = Messages.NO_AVAILABLE_READ_WRITE_DATA.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
