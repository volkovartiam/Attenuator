package volkov.artiam.mainsPanels.channel;

import volkov.artiam.arduino.PrintImpl;

public class Printer implements PrintImpl {

    @Override
    public void sendData(String command) {
        if( !command.isBlank()){
            System.out.println(command);
        }
    }

    @Override
    public boolean isReady() {
        return true;
    }

}
