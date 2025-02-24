package volkov.artiam.panels.portAndArduino;

import volkov.artiam.arduino.ArduinoService;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.datas.Additions;
import volkov.artiam.datas.Delays;

public class PortDataReader implements Runnable{

    ArduinoService arduinoAccess;
    PortAndArduinoModel port;
    Thread thread;

    PortDataReader(ArduinoService arduinoService, PortAndArduinoModel port){
        this.arduinoAccess = arduinoService;
        this.port = port;
    }

    @Override
    public void run() {
        while ( port.isPortIsOpen() ){
            try {
                arduinoAccess.readData();
            } catch (NoAvailableReadData e) {
                e.printStackTrace();
            }
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
