package volkov.artiam.panels.portAndArduino;

import volkov.artiam.arduino.ArduinoControl;
import volkov.artiam.datas.Additions;
import volkov.artiam.datas.Delays;

public class PortDisconnectChecker implements Runnable{

    ArduinoControl arduinoAccess;
    PortAndArduinoModel port;
    Thread thread;

    PortDisconnectChecker(ArduinoControl arduinoAccess, PortAndArduinoModel port){
        this.arduinoAccess = arduinoAccess;
        this.port = port;
    }

    @Override
    public void run() {
        while (true){
            Additions.waitMilliseconds(Delays.PORT_CHEKER_DELAY.getDelay());
            /*
            if( arduinoAccess.isDisconnected() ){
                port.isDisconnected();
                this.stopThread();
                break;
            } else if( !arduinoAccess.portIsOpen() ){
                this.stopThread();
                break;
            }
             */
        }
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    public void stopThread(){
        try {
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
