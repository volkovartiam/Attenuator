package volkov.artiam.panels.control;

import lombok.Getter;
import lombok.Setter;

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
	JButton btnSetAtt = pnl.btnSetAtt;

	JLabel lblAttVal = pnl.lblAttVal;
	JLabel lblAttTM = pnl.lblAttTM;
	JSlider slider = pnl.slider;

	public Control() {

		chPositive.addItemListener(this);
		chNegative.addItemListener(this);
		btnSetAtt.addActionListener(this);

		lblAttVal.setText("31.5");

		lblAttTM.setText("TM = ");

		slider.setMinimum(0);
		slider.setMaximum(63);
		slider.setValue(63);
		slider.addChangeListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if(e.getSource() == btnSetAtt) {
			System.out.println("Установить значение " + lblAttVal.getText());
		}
		


	}

	@Override
	public void stateChanged(ChangeEvent e) {
		lblAttVal.setText("" + slider.getValue() * 0.5 );
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource().equals(chPositive) ) {

			if(chPositive.isSelected()){
				System.out.println("chPositive + HIGH");
			} else {
				System.out.println("chPositive + LOW");
			}

		}
		if(e.getSource().equals(chNegative) ) {

			if(chNegative.isSelected()){
				System.out.println("chNegative + HIGH");
			} else {
				System.out.println("chNegative + LOW");
			}

		}
	}
}
