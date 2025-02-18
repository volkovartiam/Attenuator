package volkov.artiam.mainsPanels.att;

import lombok.Setter;

import javax.swing.*;
import java.util.Arrays;

public class AttModel {

	double [] attValues = {0, 0.5, 1.0, 2.0, 4.0, 8.0, 15.5};
	double attMaxValue ;

	@Setter
	JLabel lblAttDef;
	String postFix = " dB";

	AttModel() {
		try {
			attMaxValue = Arrays.stream(attValues).max().getAsDouble();
		} catch (Exception e) {
			String message = this.getClass().getName() + e.getStackTrace();
			JOptionPane.showMessageDialog(null, message);
		}
	}

	int getAttValuesLength(){
		return attValues.length;
	}

	void setCurrentAttDef(double val){
		if(val > attMaxValue) {
			val = attMaxValue;
		}
		lblAttDef.setText( getInStringWithPostfix(val) );
	}

	String getInStringWithPostfix( double val){
		return String.valueOf(val) + postFix;
	}

}
