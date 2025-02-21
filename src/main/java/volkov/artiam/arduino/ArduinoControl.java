package volkov.artiam.arduino;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.exceptions.streams.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.arduino.listeners.ListenerDisconnected;


@Setter
@Getter
public class ArduinoControl extends ArduinoService {

    private ArduinoService arduinoService = new ArduinoService();

    ListenerDisconnected listener;

    public ArduinoControl(){
        listener = new ListenerDisconnected(arduinoService.arduino);
        //listener.setArduino(arduinoService.arduino);
    }

    public void sendCommand(String command) {
        try {
            arduinoService.sendCommand(command);
        } catch (NoAvailableWriteData e){
            e.printStackTrace();
        }
    }


    public String readData()  {
        String data = "";
        try {
            data = arduinoService.readData();
        } catch (NoAvailableReadData e) {
            e.printStackTrace();
        }
        return data;
    }

}