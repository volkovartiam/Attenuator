package volkov.artiam;

import volkov.artiam.arduino.ArduinoServiceWithListeners;
import volkov.artiam.panels.mainPanel.MainPanel;

public class MainPanelController {

    MainPanel mainPanel = new MainPanel();

    ArduinoServiceWithListeners arduino = ArduinoServiceWithListeners.getInstance();

    MainPanelController(){
        mainPanel.setPrinter(arduino);
    }

}
