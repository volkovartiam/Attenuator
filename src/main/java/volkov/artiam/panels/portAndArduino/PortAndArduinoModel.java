package volkov.artiam.panels.portAndArduino;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import volkov.artiam.arduino.ArduinoSingleton;
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

	private ArduinoSingleton arduinoAccess = ArduinoSingleton.getInstance();
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
		setNewComPorts( arduinoAccess.getAvailblePortsNames() );
		selectedPort = (String) comboPortSelection.getSelectedItem();
	}


	void connect( String btnText ){
		if( btnText.equals( TEXTs.CONNECT.getText() ) ){
			boolean isParamSet = arduinoAccess.setPortByName(selectedPort);
			if( isParamSet ){
				arduinoAccess.openPort();
				portIsOpen = arduinoAccess.portIsOpen();

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
			arduinoAccess.closePort();
			setPortIsOpen(false);

			btnConnect.setText( TEXTs.CONNECT.getText() );
			btnUpdate.setEnabled(true);
			comboPortSelection.setEnabled(true);
			btnLed.setEnabled(false);
		}

	}

	void setLedCommand( String btnText) {
		if(btnText.equals( TEXTs.LED_ON.getText() )) {
			arduinoAccess.sendData(COMMANDS.C0_LED_ON.getCommand() );

			lblLedControl.setBackground(Color.GREEN);
			btnLed.setText( TEXTs.LED_OFF.getText() );
		} else if(btnText.equals( TEXTs.LED_OFF.getText()) ) {
			arduinoAccess.sendData(COMMANDS.C1_LED_OFF.getCommand());

			lblLedControl.setBackground(Color.LIGHT_GRAY);
			btnLed.setText( TEXTs.LED_ON.getText() );
		}
	}

	void update(){
		setNewComPorts( arduinoAccess.getAvailblePortsNames() );
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