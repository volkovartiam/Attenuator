package volkov.artiam.panels.control;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;
import volkov.artiam.printers.NoPrinter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@Getter @Setter
public class Control implements ActionListener, ChangeListener, ItemListener {

	ControlView pnl = new ControlView();
	JCheckBox chPositive = pnl.chPositive;
	JCheckBox chNegative = pnl.chNegative;
	JCheckBox chSliderEnable = pnl.chSliderEnable;
	JButton btnSetAtt = pnl.btnSetAtt;

	private JLabel lblAttVal = pnl.lblAttVal;
	JLabel lblAttTM = pnl.lblAttTM;
	JSlider slider = pnl.slider;

	double attValue = 31.5;
	private IPrinter printer = new NoPrinter();

	public Control() {

		chPositive.addItemListener(this);
		chNegative.addItemListener(this);
		btnSetAtt.addActionListener(this);

		lblAttVal.setText("" + attValue);

		lblAttTM.setText("TM = ");

		slider.setMinimum(0);
		slider.setMaximum(63);
		slider.setValue(63);
		slider.addChangeListener(this);

	}

	public void setLblAttVal(){
		lblAttVal.setText("" + attValue);
	}

	public void setEnabled(boolean enabled){
		chPositive.setEnabled(enabled);
		chNegative.setEnabled(enabled);
		chSliderEnable.setEnabled(enabled);
		btnSetAtt.setEnabled(enabled);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//String actionCommand = e.getActionCommand();

		if(e.getSource() == btnSetAtt) {
			printer.print("Установить значение " + lblAttVal.getText() );
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		attValue = slider.getValue() * 0.5;
		lblAttVal.setText("" + attValue);
		printer.print("Значение аттенюации = " + attValue);
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

		if(e.getSource().equals(chSliderEnable) ) {

			if(chPositive.isSelected()){
				printer.print("chSliderEnable + HIGH");
			} else {
				printer.print("chSliderEnable + LOW");
			}
		}

	}
}
