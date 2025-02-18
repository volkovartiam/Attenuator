package volkov.artiam.arduino;

import volkov.artiam.arduino.exceptions.NoAvailableReadData;
import volkov.artiam.arduino.exceptions.NoAvailableReadWriteData;
import volkov.artiam.arduino.exceptions.NoAvailableWriteData;
import volkov.artiam.datas.Additions;
import java.io.IOException;

public class ArduinoServiceDebug {

    public static void main(String[] args ) throws IOException, NoAvailableWriteData, NoAvailableReadData {

        ArduinoService arduinoService = new ArduinoService(); //ArduinoService.getInstance();

        System.out.println(arduinoService.setPortByName("COM4") );
        System.out.println(arduinoService.openPort() );

        try {
            arduinoService.initOutputAndInput();
        }catch (NoAvailableReadWriteData e){
            e.printStackTrace();
        }


        Additions.waitMilliseconds();

        int i = 5;
        while (true) {
            arduinoService.sendData("LED;ON;");
            Additions.waitMilliseconds();
            System.out.println(arduinoService.readData() );
            i--;
            if(i < 0) {
                break;
            }
        }


    }
}
