package volkov.artiam.panels.control;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.panels.CastChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;

@Getter @Setter
public class Control extends CastChangeListener implements ActionListener, ItemListener, ChangeListener {

	ControlView pnl = new ControlView();
	JCheckBox chPositive = pnl.chPositive;
	JCheckBox chNegative = pnl.chNegative;
	JCheckBox chSliderEnable = pnl.chSliderEnable;
	JButton btnSetAtt = pnl.btnSetAtt;

	private JLabel lblAttVal = pnl.lblAttVal;
	JLabel lblAttTM = pnl.lblAttTM;
	JSlider slider = pnl.slider;

	double attValue = 31.5;


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


	public void setTm(String data){
		lblAttTM.setText("TM = " + data);
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if (propertyName.equals(news) ) {

		}
		else if(propertyName.equals(commands) ) {

		}
		else if(propertyName.equals(tm) ) {
			String tmDatas =  (String)evt.getNewValue();
			setTm(tmDatas);
		}
	}

}
