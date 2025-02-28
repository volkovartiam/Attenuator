package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.datas.ADDS;
import volkov.artiam.datas.DATAS;
import volkov.artiam.printers.IPrinter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Setter @Getter
public class ArduinoServiceWithListeners extends ArduinoService implements IPrinter{

    private PropertyChangeSupport supportRx;

    private static ArduinoServiceWithListeners instance;
    public static ArduinoServiceWithListeners getInstance(){
        if(instance == null) {
            instance = new ArduinoServiceWithListeners();
        }
        return instance;
    }

    private ArduinoServiceWithListeners(){
        super();
        supportRx = new PropertyChangeSupport(this);
    }

    @Override
    public void print(Object command) {
        try {
            this.sendCommand(command.toString());
            this.notifyAboutNewCommand(command.toString());
        } catch (NoAvailableWriteData e) {
            e.printStackTrace();
        }
        this.getPrinter().print(command);
    }

    @Override
    public void print(Object object, boolean isPrintable) {
        if(isPrintable){
            print(object);
        }
    }

    @Override
    public String readData(){
        String data = "";
        try {
            data = super.readData();
            if( !data.isEmpty() || !data.isBlank()) {
                notifyAboutNewData(data);
            }
        } catch (NoAvailableReadData e) {
            e.printStackTrace();
        }
        return data;
    }


    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        supportRx.addPropertyChangeListener(pcl);
    }


    public void notifyAboutNewCommand(String command) {
        String oldCommand = "";
        String newCommand = ADDS.getCurrentTimeStamp() + command ;
        supportRx.firePropertyChange(DATAS.PCL_COMMAND.toString(), oldCommand, newCommand);
    }


    public void notifyAboutNewData(String data) {
        notifyAboutNewTM(data);
        String oldData = "";
        String newData = ADDS.getCurrentTimeStamp() + data ;
        supportRx.firePropertyChange(DATAS.PCL_NEWS.toString(), oldData, newData);
    }


    public void notifyAboutNewTM(String data) {
        String oldTM = "";
        String newTM = data ;
        supportRx.firePropertyChange(DATAS.PCL_TM.toString(), oldTM, newTM);
    }


}