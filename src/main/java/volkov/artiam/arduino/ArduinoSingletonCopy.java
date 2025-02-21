package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.datas.Additions;
import volkov.artiam.datas.Delays;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Setter @Getter
public class ArduinoSingletonCopy implements PrintImpl {

    private ArduinoService arduinoService ;
    private static ArduinoSingletonCopy instance;

    private PropertyChangeSupport supportRx;
    private String data = "" ;
    private String newCommand = "" ;


    public ArduinoSingletonCopy(){
        arduinoService = new ArduinoService();
        supportRx = new PropertyChangeSupport(this);
    }

    public static ArduinoSingletonCopy getInstance(){
        if(instance == null) {
            instance = new ArduinoSingletonCopy();
        }
        return instance;
    }

    public boolean setPortByName(String portName){
        return arduinoService.setPortByName(portName);
   }

    public void openPort() {
        arduinoService.openPort();
        Additions.waitMilliseconds(Delays.AFTER_CONNECT_DELAY.getDelay());
        try {
            arduinoService.initReaderWriter();
        }catch (NoAvailableReadWriteData e){
        }
    }

    public boolean portIsOpen(){
        return arduinoService.isOpen();
    }

    public void closePort() {
        arduinoService.closePort();
    }

    @Override
    public void sendData(String command) {
        try {
            if( !command.isEmpty() && !command.isBlank() ){
                arduinoService.sendCommand(command);
                setNewCommand(command);
                Additions.waitMilliseconds(Delays.SEND_DATA_DELAY.getDelay());
            }
        } catch (NoAvailableWriteData e){
        }
    }

    @Override
    public boolean isReady() {
        return arduinoService.isOpen();
    }


    public void readData()  {
        try {
            String data = arduinoService.readData();
            if( !data.isEmpty() || !data.isBlank()) {
                setNewData(data);
                System.out.println( this.getClass().getName() + " " +  data);
            }
        } catch (NoAvailableReadData e) {
        }
    }

    public boolean isDisconnected(){
        //return arduinoService.isDisconnected();
        return false;
    }

    /*
    public String[] getAvailblePortsNames() {
        return arduinoService.getAvailablePortsNames();
    }
    */

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        supportRx.addPropertyChangeListener(pcl);
    }

    public void setNewData (String data) {
        setNewDataWithoutTime(data);
        String oldValue = "";
        String receivedDataFromArduino = Additions.getCurrentTimeStamp() + data ;
        supportRx.firePropertyChange("news", oldValue, receivedDataFromArduino);
    }

    public void setNewCommand (String command) {
        String oldValue = "";
        String comandToArduino = Additions.getCurrentTimeStamp() + command ;
        supportRx.firePropertyChange("command", oldValue, comandToArduino);
    }

    public void setNewDataWithoutTime (String data) {
        String oldValue = "";
        String receivedDataFromArduino = data ;
        supportRx.firePropertyChange("tm", oldValue, receivedDataFromArduino);
    }

}