package volkov.artiam.arduino.exceptions.streams;

import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.*;

public class NoAvailableWriteData extends Exception {

    public NoAvailableWriteData(){
        String message = MESSAGES.NO_AVAILABLE_WRITE_DATA.toString();
        JOptionPane.showMessageDialog(null, message);
    }
}
