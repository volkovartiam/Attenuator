package volkov.artiam.arduino.exceptions.streams;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class NoAvailableWriteData extends Exception {

    public NoAvailableWriteData(){
        String message = Messages.NO_AVAILABLE_WRITE_DATA.getMessage();
        JOptionPane.showMessageDialog(null, message);
    }
}
