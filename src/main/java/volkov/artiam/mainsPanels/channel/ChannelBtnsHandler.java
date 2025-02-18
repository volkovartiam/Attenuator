package volkov.artiam.mainsPanels.channel;

import lombok.Setter;
import volkov.artiam.datas.TEXTs;
import volkov.artiam.arduino.PrintImpl;
import volkov.artiam.datas.COMMANDS;

import javax.swing.*;

@Setter
public class ChannelBtnsHandler {

    JButton btn5V;
    JButton btnMain4V;
    JButton btnReserve4V;
    JButton btnSetAtt;


    JCheckBox chTmAuto;
    JLabel lblAttDef;

    PrintImpl printer;
    String tag = "";

    void init( ) {
        attAvailble(false);
    }

    void attAvailble(boolean enabled){
        btnSetAtt.setEnabled(enabled);
        chTmAuto.setEnabled(enabled);

    }


    private boolean isReady(){
        boolean isReady;
        try {
            isReady = printer.isReady();
        } catch (Exception e) {
            return false;
        }
        return isReady;
    }

}
