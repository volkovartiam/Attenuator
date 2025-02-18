package volkov.artiam.mainsPanels.port;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
public class PnlPortModel {

	JLabel lblLedControl;
	JButton btnConnect;
	JButton btnLed;
	JButton btnUpdate;
	JComboBox<String> comboPortSelection;

	boolean ledControlOn;

	String ledOn = "Контроль ВКЛ";
	String ledOff = "Контроль ОТКЛ";
	String connect = "Подключение";
	String disconnect = "Отключение" ;

	String selectedComPort = "";

	void init(){
		setLedControlOn(false);
		btnLed.setEnabled(false);
	}

	void setLed() {
		setLedControlOn( !ledControlOn);
		if(ledControlOn){
			lblLedControl.setBackground(Color.GREEN);
			btnLed.setText(ledOff);
		} else {
			lblLedControl.setBackground(Color.LIGHT_GRAY);
			btnLed.setText(ledOn);
		}
	}

	void isConnected(boolean isConnected){
		if(isConnected){
			btnConnect.setText(disconnect);
			btnUpdate.setEnabled(false);
			comboPortSelection.setEnabled(false);
			btnLed.setEnabled(true);
		} else {
			btnConnect.setText(connect);
			btnUpdate.setEnabled(true);
			comboPortSelection.setEnabled(true);
			btnLed.setEnabled(false);
		}
	}

	void isDisconnected(boolean isDisconnected){
		btnLed.setEnabled(false);
		btnUpdate.setEnabled(true);
		comboPortSelection.setEnabled(true);
		btnConnect.setText(connect);
	}



	public void setNewComPorts(String[] args){
		comboPortSelection.removeAllItems();
		for (String str : args) {
			comboPortSelection.addItem(str);
		}
	}


}