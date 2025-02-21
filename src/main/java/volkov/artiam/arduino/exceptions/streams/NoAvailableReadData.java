package volkov.artiam.arduino.exceptions.streams;

import volkov.artiam.datas.Messages;

import javax.swing.*;

public class NoAvailableReadData extends Exception {

    public NoAvailableReadData(String string){
        String message = Messages.NO_AVAILABLE_READ_DATA.getMessage();
        JOptionPane.showMessageDialog(null, message + "\n" + string);
    }
}
