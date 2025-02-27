package volkov.artiam.panels.mainPanel;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.COMMANDS;
import volkov.artiam.datas.TEXTs;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


@Setter @Getter
public class MainPanel implements ActionListener, ItemListener {

	MainPanelView pnl = new MainPanelView();

	JButton btnConnect = pnl.port.getBtnConnect();
	JButton btnUpdate = pnl.port.getBtnUpdate();
	JButton btnLed = pnl.port.getBtnLed();

	JButton btnSetAtt = pnl.control.getBtnSetAtt();
	JCheckBox chPositive = pnl.control.getChPositive();
	JCheckBox chNegative = pnl.control.getChNegative();
	JCheckBox chSlider = pnl.control.getChSliderEnable();

	String LED_ON = TEXTs.LED_ON.get();
	String LED_OFF = TEXTs.LED_OFF.get();
	String CONNECT = TEXTs.CONNECT.get();
	String DISCONNECT = TEXTs.DISCONNECT.get();

	boolean sliderIsEnabled = false;
	double attValue = 0;

	IPrinter printer = new ConsolePrinter();

	public MainPanel(){

		btnConnect.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnLed.addActionListener(this);

		btnSetAtt.addActionListener(this);

		chPositive.addItemListener(this);
		chNegative.addItemListener(this);
		chSlider.addItemListener(this);

		setSliderEnableOrNotView(chSlider.isSelected() );
		setConnectedOrDisconnectedView(false);
	}


	void setSliderEnableOrNotView(boolean sliderEnabled){
		pnl.control.getSlider().setEnabled(sliderEnabled);
		pnl.att.setEnabled(!sliderEnabled);
		updateValueAndLabels();
	}

	public void setPorts(String[] ports){
		pnl.port.setPorts(ports);
	}

	public String getSelectedPort(){
		return pnl.port.getSelectedPort();
	}

	private void updateValueAndLabels(){
		if(sliderIsEnabled){
			pnl.control.setLblAttVal();
			attValue = pnl.control.getAttValue();
		} else {
			pnl.control.getLblAttVal().setText("");
			attValue = pnl.att.getAttValue();
		}
	}


	public void setConnectedOrDisconnectedView(boolean isConnected){
		pnl.port.setConnectedOrDisconnectedView(isConnected);
		pnl.control.setEnabled(isConnected);
		pnl.att.setEnabled(isConnected);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (e.getSource().equals(btnConnect)) {
			if(actionCommand.equals(CONNECT)) {
				//printer.print(COMMANDS.CONNECT);
			}
			if(actionCommand.equals(DISCONNECT)) {
				//printer.print(COMMANDS.DISCONNECT);
			}
		}

		if (e.getSource().equals(btnUpdate)) {
			//printer.print(COMMANDS.UPDATE);
		}

		if (e.getSource().equals(btnLed)) {
			if(actionCommand.equals(LED_ON)) {
				printer.print(COMMANDS.LED_ON);
			}
			if(actionCommand.equals(LED_OFF)) {
				printer.print(COMMANDS.LED_OFF);
			}
		}

		if (e.getSource().equals(btnSetAtt)) {
			updateValueAndLabels();
			printer.print(COMMANDS.ATT + "" + attValue + ";");
		}

	}



	@Override
	public void itemStateChanged(ItemEvent e) {

		if(e.getSource().equals(chPositive) ) {
			if(chPositive.isSelected()){
				printer.print(COMMANDS.POS_3_3V_ON);
			} else {
				printer.print(COMMANDS.POS_3_3V_OFF);
			}
		}

		if(e.getSource().equals(chNegative) ) {
			if(chNegative.isSelected()){
				printer.print(COMMANDS.NEG_3_3V_ON);
			} else {
				printer.print(COMMANDS.NEG_3_3V_OFF);
			}
		}

		if(e.getSource().equals(chSlider) ) {
			if(chSlider.isSelected()){
				sliderIsEnabled = true;
				printer.print("SLIDER;ON;");
			} else {
				sliderIsEnabled = false;
				printer.print("SLIDER;OFF;");
			}
			updateValueAndLabels();
			setSliderEnableOrNotView(sliderIsEnabled);
		}

	}
}
