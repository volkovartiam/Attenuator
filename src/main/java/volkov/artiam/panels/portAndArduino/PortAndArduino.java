package volkov.artiam.panels.portAndArduino;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PortAndArduino implements ActionListener, ItemListener {

	PortAndArduinoModel model = new PortAndArduinoModel();

	@Getter
	JPanel pnl;
	public JButton btnConnect;
	JButton btnLed;
	JButton btnUpdate;
	JComboBox<String> comboPortSelection;

	public PortAndArduino() {
		model.init();
		pnl = model.getPanel();

		btnConnect = model.getBtnConnect();
		btnLed = model.getBtnLed();
		btnUpdate = model.getBtnUpdate() ;
		comboPortSelection = model.getComboPortSelection();

		btnConnect.addActionListener(this);
		btnLed.addActionListener(this);
		btnUpdate.addActionListener(this);
		comboPortSelection.addItemListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConnect ){
			model.connect( btnConnect.getText() );
		}
		if(e.getSource() == btnLed){
			model.setLedCommand( btnLed.getText() );
		}
		if(e.getSource() == btnUpdate){
			model.update();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals( comboPortSelection ) ) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				model.setNewComPort();
			}
		}
	}

}
