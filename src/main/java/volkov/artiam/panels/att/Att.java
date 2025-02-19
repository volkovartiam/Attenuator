package volkov.artiam.panels.att;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Att implements ItemListener {

	AttView pnl = new AttView();
	HashMap<JCheckBox, Double> checkboxesAndValues = new HashMap<>();
	ArrayList<JCheckBox> checkBoxes = pnl.checkBoxes;

	private double [] attValues = {0, 0.5, 1.0, 2.0, 4.0, 8.0, 16.0, 31.5};
	private double attMaxValue ;

	public JLabel lblAttDef = pnl.lblAttDef;
	private String postFix = " dB";
	double attValue = 0;

	public Att() {

		if(isEqualSize(attValues,  checkBoxes) ) {

			setAttMaxVAlue();
			for (int i = 0; i < checkBoxes.size(); i++) {
				checkboxesAndValues.put(checkBoxes.get(i), attValues[i]);
				checkBoxes.get(i).addItemListener(this);
			}
			for (Map.Entry<JCheckBox, Double> set : checkboxesAndValues.entrySet()) {
				setTextToCheckbox(set.getKey(), set.getValue() +  postFix );
			}
			checkBoxes.get(checkBoxes.size() - 1).setSelected(true);
			setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(null, "Количество чек-боксов и значений аттенюаций различно!!!" );
		}
	}

	private void setAttMaxVAlue() {
		try {
			attMaxValue = Arrays.stream(attValues).max().getAsDouble();
		} catch (Exception e) {
			String message = this.getClass().getName() + e.getStackTrace();
			JOptionPane.showMessageDialog(null, message);
		}
	}

	private boolean isEqualSize(double[] values, ArrayList<JCheckBox> checkBoxes ) {
		return values.length == checkBoxes.size();
	}

	private void setTextToCheckbox(JCheckBox jcb, String value){
		jcb.setText( value);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		for (JCheckBox jcb : pnl.checkBoxes) {
			if(e.getSource().equals(jcb) ) {
				setNewAttValue();
			}
		}
	}

	private void setNewAttValue(){
		double value = 0;
		for (JCheckBox jcb : pnl.checkBoxes) {
			if(jcb.isSelected() ) {
				value += checkboxesAndValues.get(jcb);
			}
		}
		if(value > attMaxValue) {
			value = attMaxValue;
		}
		attValue = value;
		lblAttDef.setText( attValue + postFix );
	}

	public void setEnabled(boolean enabled){
		for (JCheckBox jch: checkBoxes) {
			jch.setEnabled(enabled);
		}
	}

}
