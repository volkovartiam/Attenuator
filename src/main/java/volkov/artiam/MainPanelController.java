package volkov.artiam;

import volkov.artiam.arduino.ArduinoChecker;
import volkov.artiam.arduino.ArduinoServiceWithListeners;
import volkov.artiam.datas.ADDS;
import volkov.artiam.datas.DATAS;
import volkov.artiam.datas.DELAYS;
import volkov.artiam.panels.mainPanel.MainPanel;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;
import volkov.artiam.printers.NoPrinter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPanelController implements ActionListener {

    MainPanel mainPanel = new MainPanel();
    JButton btnUpdate = mainPanel.getBtnUpdate();
    JButton btnConnect = mainPanel.getBtnConnect();

    String connect = DATAS.CONNECT_BUTTON.toString();
    String disconnect = DATAS.DISCONNECT_BUTTON.toString();

    ArduinoServiceWithListeners arduino = ArduinoServiceWithListeners.getInstance();
    IPrinter printer = new ConsolePrinter();

    ArduinoChecker arduinoChecker = new ArduinoChecker();

    MainPanelController(){
        mainPanel.setPrinter(arduino);
        mainPanel.setPorts( arduino.getPortsNames() );

        btnUpdate.addActionListener(this);
        btnConnect.addActionListener(this);

        arduino.addPropertyChangeListener(mainPanel.pnl.att);
        arduino.addPropertyChangeListener(mainPanel.pnl.console);
        arduino.addPropertyChangeListener(mainPanel.pnl.control);
        arduino.addPropertyChangeListener(mainPanel);
        arduino.addPropertyChangeListener(mainPanel.pnl.port);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if(e.getSource().equals(btnUpdate)) {
            mainPanel.setPorts( arduino.getPortsNames() );

            printer.print("btnUpdate");
        }
        if(e.getSource().equals(btnConnect)) {
            if(actionCommand.equals(connect)) {
                arduino.setPortByName(mainPanel.getSelectedPort());
                arduino.openPort();
            }
            if(actionCommand.equals(disconnect)) {
                arduino.closePort();
            }
            mainPanel.setConnectedOrDisconnectedView(arduino.isOpen() );
            if(arduino.isOpen()){
                arduinoChecker.setPort();
                arduinoChecker.thread.start();
            }
            printer.print("btnConnect");
        }

        if(e.getSource().equals("Disconnected")) {
            printer.print("Something");
        }

    }




}
