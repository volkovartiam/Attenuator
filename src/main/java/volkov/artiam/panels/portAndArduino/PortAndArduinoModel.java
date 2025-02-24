package volkov.artiam.panels.portAndArduino;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import volkov.artiam.arduino.ArduinoService;
import volkov.artiam.arduino.exceptions.ports.NoAvailableClosePort;
import volkov.artiam.arduino.exceptions.ports.NoAvailableOpenPort;
import volkov.artiam.arduino.exceptions.ports.ÑheckIsOpenPortException;
import volkov.artiam.arduino.exceptions.streams.NoAvailableWriteData;
import volkov.artiam.datas.COMMANDS;
import volkov.artiam.datas.TEXTs;
import volkov.artiam.panels.port.PortView;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
public class PortAndArduinoModel {

	PortView panel = new PortView();

	private ArduinoService arduinoAccess = new ArduinoService();
	private PortDataReader portDataReader = new PortDataReader(arduinoAccess, this);
	private PortDisconnectChecker portDisconnectChecker = new PortDisconnectChecker(arduinoAccess, this);

	JButton btnConnect = panel.getBtnConnect();
	JButton btnLed = panel.getBtnLed();
	JButton btnUpdate = panel.getBtnUpdate();
	JComboBox<String> comboPortSelection = panel.getComboPortSelection();

	private JLabel lblLedControl = panel.getLblLed();
	private String selectedPort = "";

	boolean portIsOpen = false;

	void init(){
		btnLed.setEnabled(false);
		setNewComPorts( arduinoAccess.getPortsNames() );
		selectedPort = (String) comboPortSelection.getSelectedItem();
	}


	void connect( String btnText ){
		if( btnText.equals( TEXTs.CONNECT.getText() ) ){
			boolean isParamSet = arduinoAccess.setPortByName(selectedPort);
			if( isParamSet ){

				try {
					arduinoAccess.openPort();
				} catch (NoAvailableOpenPort e) {
					e.printStackTrace();
				}

				try {
					portIsOpen = arduinoAccess.isOpen();
				} catch (ÑheckIsOpenPortException e) {
					e.printStackTrace();
				}

				if( portIsOpen ){
					portDataReader.startThread();
					portDisconnectChecker.startThread();

					btnConnect.setText( TEXTs.DISCONNECT.getText() );
					btnUpdate.setEnabled(false);
					comboPortSelection.setEnabled(false);
					btnLed.setEnabled(true);
				}
			}
		} else if (btnText.equals( TEXTs.DISCONNECT.getText()) ) {
			try {
				arduinoAccess.closePort();
			} catch (NoAvailableClosePort e) {
				e.printStackTrace();
			}
			setPortIsOpen(false);

			btnConnect.setText( TEXTs.CONNECT.getText() );
			btnUpdate.setEnabled(true);
			comboPortSelection.setEnabled(true);
			btnLed.setEnabled(false);
		}

	}

	void setLedCommand( String btnText) {
		if(btnText.equals( TEXTs.LED_ON.getText() )) {
			try {
				arduinoAccess.sendCommand(COMMANDS.C0_LED_ON.getCommand() );
			} catch (NoAvailableWriteData e) {
				e.printStackTrace();
			}

			lblLedControl.setBackground(Color.GREEN);
			btnLed.setText( TEXTs.LED_OFF.getText() );
		} else if(btnText.equals( TEXTs.LED_OFF.getText()) ) {
			try {
				arduinoAccess.sendCommand(COMMANDS.C1_LED_OFF.getCommand());
			} catch (NoAvailableWriteData e) {
				e.printStackTrace();
			}

			lblLedControl.setBackground(Color.LIGHT_GRAY);
			btnLed.setText( TEXTs.LED_ON.getText() );
		}
	}

	void update(){
		setNewComPorts( arduinoAccess.getPortsNames() );
	}


	void setNewComPort(){
		selectedPort = (String) comboPortSelection.getSelectedItem();
	}

	void setNewComPorts(String[] args){
		comboPortSelection.removeAllItems();
		for (String str : args) {
			comboPortSelection.addItem(str);
		}
	}

	void isDisconnected(){
		setPortIsOpen(false);
		btnLed.setEnabled(false);
		btnUpdate.setEnabled(true);
		comboPortSelection.setEnabled(true);
		btnConnect.setText( TEXTs.CONNECT.getText() );
	}

}