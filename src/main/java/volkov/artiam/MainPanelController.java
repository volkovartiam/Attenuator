package volkov.artiam;

import volkov.artiam.arduino.ArduinoServiceWithListeners;
import volkov.artiam.datas.COMMANDS;
import volkov.artiam.datas.TEXTs;
import volkov.artiam.panels.mainPanel.MainPanel;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPanelController implements ActionListener {

    MainPanel mainPanel = new MainPanel();
    JButton btnUpdate = mainPanel.getBtnUpdate();
    JButton btnConnect = mainPanel.getBtnConnect();

    ArduinoServiceWithListeners arduino = ArduinoServiceWithListeners.getInstance();
    IPrinter printer = new ConsolePrinter();

    MainPanelController(){
        mainPanel.setPrinter(arduino);
        mainPanel.setPorts( arduino.getPortsNames() );

        btnUpdate.addActionListener(this);
        btnConnect.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(e.getSource().equals(btnUpdate)) {
            mainPanel.setPorts( arduino.getPortsNames() );
            printer.print("btnUpdate");
        }
        if(e.getSource().equals(btnConnect)) {

            if(actionCommand.equals(TEXTs.CONNECT.get() )) {
                arduino.setPortByName(mainPanel.getSelectedPort());

                arduino.openPort();
            }
            if(actionCommand.equals(TEXTs.DISCONNECT.get())) {
                arduino.closePort();
            }
            mainPanel.setConnectedOrDisconnectedView(arduino.isConnected());
            printer.print("btnConnect");
        }

    }




}
