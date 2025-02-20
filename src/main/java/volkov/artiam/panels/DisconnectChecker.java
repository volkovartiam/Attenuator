package volkov.artiam.panels;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.arduino.ArduinoSingleton;
import volkov.artiam.datas.Additions;
import volkov.artiam.datas.Delays;
import volkov.artiam.datas.TEXTs;
import volkov.artiam.panels.mainPanel.MainPanelView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class DisconnectChecker implements Runnable, ActionListener {

    private ArduinoSingleton arduinoAccess;
    @Setter
    JButton btnConnect; // = new JButton();
    private MainPanelView panel;
    private Thread thread;

    String CONNECT = TEXTs.CONNECT.getText();
    String DISCONNECT = TEXTs.DISCONNECT.getText();


    void init(MainPanelView panel){
        this.arduinoAccess = ArduinoSingleton.getInstance();
        this.panel = panel;
        this.btnConnect.addActionListener(this);
    }

    @Override
    public void run() {
        while (true){
            Additions.waitMilliseconds(Delays.PORT_CHEKER_DELAY.getDelay());
            if( arduinoAccess.isDisconnected() || !arduinoAccess.portIsOpen() ){
                panel.setEnabled(false);
                this.stopThread();
                break;
            }
        }
    }

    public void startThread(){
        panel.setEnabled(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals(CONNECT)) {
            this.startThread();
        }
        if (actionCommand.equals(DISCONNECT)) {
            this.stopThread();
        }
    }
}
