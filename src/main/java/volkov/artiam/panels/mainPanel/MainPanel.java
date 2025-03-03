package volkov.artiam.panels.mainPanel;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.DATAS;
import volkov.artiam.panels.CastChangeListener;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;


@Setter @Getter
public class MainPanel extends CastChangeListener implements ActionListener, ItemListener {

	public MainPanelView pnl = new MainPanelView();

	JButton btnConnect = pnl.port.getBtnConnect();
	JButton btnUpdate = pnl.port.getBtnUpdate();
	JButton btnLed = pnl.port.getBtnLed();

	JButton btnSetAtt = pnl.control.getBtnSetAtt();
	JCheckBox chPositive = pnl.control.getChPositive();
	JCheckBox chNegative = pnl.control.getChNegative();
	JCheckBox chSlider = pnl.control.getChSliderEnable();
	JCheckBox chAttAuto = pnl.control.getChAttAuto();

	String LED_ON = DATAS.LED_ON_BUTTON.toString();
	String LED_OFF = DATAS.LED_OFF_BUTTON.toString();
	String CONNECT = DATAS.CONNECT_BUTTON.toString();
	String DISCONNECT = DATAS.DISCONNECT_BUTTON.toString();

	boolean sliderIsEnabled = false;
	double attValue = 0;


	public MainPanel(){

		btnConnect.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnLed.addActionListener(this);

		btnSetAtt.addActionListener(this);

		chPositive.addItemListener(this);
		chNegative.addItemListener(this);
		chSlider.addItemListener(this);
		chAttAuto.addItemListener(this);

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
				printer.print(DATAS.CONNECT, false);
			}
			if(actionCommand.equals(DISCONNECT)) {
				printer.print(DATAS.DISCONNECT, false);
			}
		}

		if (e.getSource().equals(btnUpdate)) {
			printer.print(DATAS.UPDATE, false);
		}

		if (e.getSource().equals(btnLed)) {
			if(actionCommand.equals(LED_ON)) {
				printer.print(DATAS.LED_ON);
			}
			if(actionCommand.equals(LED_OFF)) {
				printer.print(DATAS.LED_OFF);
			}
		}

		if (e.getSource().equals(btnSetAtt)) {
			updateValueAndLabels();
			printer.print(DATAS.ATT + "" + attValue + ";");
		}

	}



	@Override
	public void itemStateChanged(ItemEvent e) {

		if(e.getSource().equals(chPositive) ) {
			if(chPositive.isSelected()){
				printer.print(DATAS.POS_3_3V_ON);
			} else {
				printer.print(DATAS.POS_3_3V_OFF);
			}
		}

		if(e.getSource().equals(chNegative) ) {
			if(chNegative.isSelected()){
				printer.print(DATAS.NEG_3_3V_ON);
			} else {
				printer.print(DATAS.NEG_3_3V_OFF);
			}
		}

		if(e.getSource().equals(chSlider) ) {
			if(chSlider.isSelected()){
				sliderIsEnabled = true;
				printer.print("SLIDER;ON;", false);
			} else {
				sliderIsEnabled = false;
				printer.print("SLIDER;OFF;", false);
			}
			updateValueAndLabels();
			setSliderEnableOrNotView(sliderIsEnabled);
		}


		if(e.getSource().equals(chAttAuto) ) {
			if(chAttAuto.isSelected()){
				printer.print(DATAS.ATT_AUTO_ON);
			} else {
				printer.print(DATAS.ATT_AUTO_OFF);
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
