package volkov.artiam.arduino.exceptions.streams;

import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.*;

public class NoAvailableReadWriteData extends Exception {

    public NoAvailableReadWriteData(){
        String message = MESSAGES.NO_AVAILABLE_READ_WRITE_DATA.toString();
        JOptionPane.showMessageDialog(null, message);
    }
}
