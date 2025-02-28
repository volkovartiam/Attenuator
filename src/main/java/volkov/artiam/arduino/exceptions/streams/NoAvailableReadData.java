package volkov.artiam.arduino.exceptions.streams;

import volkov.artiam.arduino.exceptions.MESSAGES;

import javax.swing.*;

public class NoAvailableReadData extends Exception {

    public NoAvailableReadData(String string){
        String message = MESSAGES.NO_AVAILABLE_READ_DATA.toString();
        JOptionPane.showMessageDialog(null, message + "\n" + string);
    }
}
