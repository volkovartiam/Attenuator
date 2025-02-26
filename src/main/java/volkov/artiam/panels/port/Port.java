package volkov.artiam.panels.port;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.printers.IPrinter;
import volkov.artiam.printers.NoPrinter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@Getter @Setter
public class Port implements ActionListener, ItemListener {

	PortView pnl = new PortView();
	JButton btnConnect = pnl.getBtnConnect();
	JButton btnLed = pnl.getBtnLed();
	JButton btnUpdate = pnl.getBtnUpdate();
	JComboBox<String> comboPortSelection  = pnl.getComboPortSelection();
	private JLabel lblLed = pnl.getLblLed();

	String selectedPort = "";

	private String ledOn = "Контроль ВКЛ";
	private String ledOff = "Контроль ОТКЛ";
	private String connect = "Подключение";
	private String disconnect = "Отключение" ;

	private boolean ledViewOn = false;
	private IPrinter printer = new NoPrinter();

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


}