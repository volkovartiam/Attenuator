package volkov.artiam.panels.mainPanel;

import lombok.Getter;
import lombok.Setter;
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

	/*
	String ON = TEXTs.ON.getText();
	String OFF = TEXTs.OFF.getText();
	String CONNECT = TEXTs.CONNECT.getText();
	String DISCONNECT = TEXTs.DISCONNECT.getText();
	*/

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


	private void updateValueAndLabels(){
		if(sliderIsEnabled){
			pnl.control.setLblAttVal();
			attValue = pnl.control.getAttValue();
		} else {
			pnl.control.getLblAttVal().setText("");
			attValue = pnl.att.getAttValue();
		}
	}


	void setConnectedOrDisconnectedView(boolean isConnected){
		pnl.port.setConnectedOrDisconnectedView(isConnected);
		pnl.control.setEnabled(isConnected);
		pnl.att.setEnabled(isConnected);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	//	String actionCommand = e.getActionCommand();


		if (e.getSource().equals(btnConnect)) {
			printer.print("btnConnect");
		}

		if (e.getSource().equals(btnUpdate)) {
			printer.print("btnUpdate");
		}

		if (e.getSource().equals(btnLed)) {
			printer.print("btnLed");
		}

		if (e.getSource().equals(btnSetAtt)) {
			updateValueAndLabels();
			printer.print("Значение аттенюатора " + attValue);
		}

	}



	@Override
	public void itemStateChanged(ItemEvent e) {

		if(e.getSource().equals(chPositive) ) {
			if(chPositive.isSelected()){
				printer.print("chPositive + HIGH");
			} else {
				printer.print("chPositive + LOW");
			}
		}

		if(e.getSource().equals(chNegative) ) {
			if(chNegative.isSelected()){
				printer.print("chNegative + HIGH");
			} else {
				printer.print("chNegative + LOW");
			}
		}

		if(e.getSource().equals(chSlider) ) {
			if(chSlider.isSelected()){
				sliderIsEnabled = true;
				printer.print("chSlider + HIGH");
			} else {
				sliderIsEnabled = false;
				printer.print("chNegative + LOW");
			}
			updateValueAndLabels();
			setSliderEnableOrNotView(sliderIsEnabled);
		}

	}
}
