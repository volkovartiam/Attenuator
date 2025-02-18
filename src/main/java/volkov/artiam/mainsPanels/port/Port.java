package volkov.artiam.mainsPanels.port;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@Getter @Setter
public class Port implements ActionListener, ItemListener {

	public PnlPortView pnl = new PnlPortView();
	PnlPortModel model = new PnlPortModel();

	JButton btnConnect;
	JButton btnLed;
	JButton btnUpdate;
	JComboBox<String> comboPortSelection;

	String message = "";
	String selectedPort = "";

	public Port() {

		btnConnect = pnl.getBtnConnect();
		btnLed = pnl.getBtnLed();
		btnUpdate = pnl.getBtnUpdate();
		comboPortSelection = pnl.getComboPortSelection();
		JLabel lblLed = pnl.getLblLed();

		model.setLblLedControl(lblLed);
		model.setBtnConnect(btnConnect);
		model.setBtnLed(btnLed);
		model.setBtnUpdate(btnUpdate);
		model.setComboPortSelection(comboPortSelection);
		model.init();

		btnLed.addActionListener(this);
		btnConnect.addActionListener(this);
		btnUpdate.addActionListener(this);
		comboPortSelection.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnLed){
			model.setLed();
		}

		if(e.getSource() == btnConnect ){
			tryToConnect();
		}

		if(e.getSource() == btnUpdate){
			update();
		}
	}

	public void tryToConnect(){
		message = "tryToConnect";
		print(message);
	}

	public void update() {
		message = "update";
		print(message);
	}

	public void isConnected(boolean isConnected){
		model.isConnected(isConnected);
	}

	public void isDisconnected(boolean isDisconnected){
		model.isDisconnected(isDisconnected);
	}


	public void setNewComPorts(String[] args){
		model.setNewComPorts(args);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals( comboPortSelection ) ) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				selectedPort = (String)comboPortSelection.getSelectedItem();
				//print(selectedPort);
			}
		}
	}


	private void print(String str){
	//	System.out.println(str);
	}

}