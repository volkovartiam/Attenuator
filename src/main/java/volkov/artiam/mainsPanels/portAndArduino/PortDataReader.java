package volkov.artiam.mainsPanels.portAndArduino;

import volkov.artiam.arduino.ArduinoAccess;
import volkov.artiam.datas.Additions;
import volkov.artiam.datas.Delays;

public class PortDataReader implements Runnable{

    ArduinoAccess arduinoAccess;
    PortAndArduinoModel port;
    Thread thread;

    PortDataReader(ArduinoAccess arduinoService, PortAndArduinoModel port){
        this.arduinoAccess = arduinoService;
        this.port = port;
    }

    @Override
    public void run() {
        while ( port.isPortIsOpen() ){
            arduinoAccess.readData();
            Additions.waitMilliseconds(Delays.DATA_READER_DELAY.getDelay());
        }
        if( !port.isPortIsOpen() ){
            this.stopThread();
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
