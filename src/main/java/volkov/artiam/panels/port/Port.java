package volkov.artiam.panels.port;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.DATAS;
import volkov.artiam.panels.CastChangeListener;
import volkov.artiam.printers.IPrinter;
import volkov.artiam.printers.NoPrinter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;

@Getter @Setter
public class Port extends CastChangeListener implements ActionListener, ItemListener {

	PortView pnl = new PortView();
	JButton btnConnect = pnl.getBtnConnect();
	JButton btnLed = pnl.getBtnLed();
	JButton btnUpdate = pnl.getBtnUpdate();
	JComboBox<String> comboPortSelection  = pnl.getComboPortSelection();
	private JLabel lblLed = pnl.getLblLed();

	public String selectedPort = "";

	private String ledOn = DATAS.LED_ON_BUTTON.toString(); 				// "Контроль ВКЛ";
	private String ledOff = DATAS.LED_OFF_BUTTON.toString(); 			// "Контроль ОТКЛ";
	private String connect = DATAS.CONNECT_BUTTON.toString(); 			//"Подключение";
	private String disconnect = DATAS.DISCONNECT_BUTTON.toString(); 	//"Отключение" ;

	private boolean ledViewOn = false;

	public Port() {

		btnLed.addActionListener(this);
		btnConnect.addActionListener(this);
		btnUpdate.addActionListener(this);
		comboPortSelection.addItemListener(this);

		btnConnect.setEnabled(true);
		btnLed.setEnabled(true);
		btnUpdate.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnLed){
			ledViewOn = !ledViewOn;
			if(ledViewOn){
				lblLed.setBackground(Color.GREEN);
				btnLed.setText(ledOff);

				printer.print(ledOn);
			} else {
				lblLed.setBackground(Color.LIGHT_GRAY);
				btnLed.setText(ledOn);

				printer.print(ledOff);
			}
		}

		if(e.getSource() == btnConnect ){
			printer.print("Connect");
		}

		if(e.getSource() == btnUpdate){
			printer.print("Update");
		}
	}



	public void setConnectedOrDisconnectedView(boolean setConnectedView){
		if(setConnectedView){
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


	public void setPorts(String[] ports){
		comboPortSelection.removeAllItems();
		for (String port : ports) {
			comboPortSelection.addItem(port);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals( comboPortSelection ) ) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				selectedPort = (String)comboPortSelection.getSelectedItem();
				printer.print(selectedPort);
			}
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if (propertyName.equals(news) ) {

		}
		else if(propertyName.equals(commands) ) {

		}
		else if(propertyName.equals(tm) ) {

		}
	}

}