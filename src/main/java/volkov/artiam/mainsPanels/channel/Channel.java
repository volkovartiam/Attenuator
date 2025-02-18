package volkov.artiam.mainsPanels.channel;

import lombok.Getter;
import volkov.artiam.datas.TEXTs;
import volkov.artiam.arduino.PrintImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter
public class Channel implements ActionListener, ItemListener, PropertyChangeListener {

    ChannelView view = new ChannelView();

    JButton btnSetAtt = view.btnSetAtt;
    JCheckBox chTmAuto = view.chTmAuto;

    PrintImpl printer;
    String tag = "";

    private ChannelBtnsHandler channelBtnsHandler = new ChannelBtnsHandler();

    public Channel( ) {


        channelBtnsHandler.setBtnSetAtt(btnSetAtt);

        channelBtnsHandler.setChTmAuto(chTmAuto);
        channelBtnsHandler.setLblAttDef( view.att.getLblAttDef() );
        channelBtnsHandler.init();

        btnSetAtt.addActionListener(this);

        chTmAuto.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();



        if(e.getSource() == btnSetAtt) {
            //channelBtnsHandler.setAtt();
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(chTmAuto) ) {
            if(chTmAuto.isSelected() ) {
               // channelBtnsHandler.enabledAutoTm();
            } else {
               // channelBtnsHandler.disabledAutoTm();
            }
        }
    }

    public void setPrinter(PrintImpl printer){
        this.printer = printer;
        channelBtnsHandler.setPrinter(printer);
    }

    public void setTag(String tag){
        this.tag = tag;
        channelBtnsHandler.setTag(tag);
    }

    public void setLabelsText(String channelName, String lblSupply5Vs,
                              String lblSupply4vMain, String lblSupply4vReserve ){
        JLabel channelNameLbl = view.getChannelName();

        channelNameLbl.setText(channelName);

    }


    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if (propertyName.equals("tm") ) {
            String tm =  (String)evt.getNewValue();
        }
    }

    public void setEnable(boolean isEnabled){
        btnSetAtt.setEnabled(isEnabled);
        chTmAuto.setEnabled(isEnabled);
    }

}
