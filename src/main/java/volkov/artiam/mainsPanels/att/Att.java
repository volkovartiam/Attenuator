package volkov.artiam.mainsPanels.att;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

@Getter @Setter
public class Att implements ItemListener {

	AttView pnl = new AttView();
    AttModel model = new AttModel();
	HashMap<JCheckBox, Double> checkBoxesAndValues = new HashMap<>();

	public JLabel lblAttDef = pnl.lblAttDef;
	String message;

	public Att() {

		model.setLblAttDef(lblAttDef);
		if( model.getAttValuesLength() == pnl.checkBoxes.size() ) {
			for (int i = 0; i < pnl.checkBoxes.size(); i++) {
				JCheckBox jcb = pnl.checkBoxes.get(i);
				double value = model.attValues[i];
				checkBoxesAndValues.put(jcb, value);
				jcb.setText( model.getInStringWithPostfix( value ) );
				jcb.addItemListener(this);
			}
		} else {
			message = this.getClass().getName() + "Количество чек-боксов и значений различно!!!";
			JOptionPane.showMessageDialog(null, message);
		}

		pnl.checkBoxes.get(checkBoxesAndValues.size() - 1).setSelected(true);
	}

	// Обработа событий
	public void itemStateChanged(ItemEvent e) {
		for (JCheckBox jcb : pnl.checkBoxes) {
			if(e.getSource().equals(jcb) ) {
				//System.out.println(jcb.getText());
				setNewAttDef();
			}
		}
	}

	private void setNewAttDef(){
		double value = 0;
		for (JCheckBox jcb : pnl.checkBoxes) {
			if(jcb.isSelected() ) {
				value = value + checkBoxesAndValues.get(jcb);
			}
		}
		model.setCurrentAttDef(value);
	}

}
