package volkov.artiam.mainsPanels.control;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import volkov.artiam.datas.TEXTs;

import javax.swing.*;
import java.awt.*;

@NoArgsConstructor
@Setter @Getter
public class SuppliesModel {

	JButton btn5V = new JButton(TEXTs.ON.getText());
	JButton btnMain4V = new JButton(TEXTs.ON.getText());
	JButton btnReserve4V = new JButton(TEXTs.ON.getText());

	JLabel lbl5Vs = new JLabel();
	JLabel lblReserve4V = new JLabel();
	JLabel lblMain4V = new JLabel();

	boolean isVKL_high = false;
	boolean isMain4VL_high = false;
	boolean isReserve4VL_high = false;

	void init(){
		btnMain4V.setEnabled(false);
		btnReserve4V.setEnabled(false);
	}


	void setVKL_high(){
		btn5V.setText(TEXTs.OFF.getText());
		lbl5Vs.setBackground(Color.GREEN);
		//btnMain4V.setEnabled(true);
		//btnReserve4V.setEnabled(true);
	}

	void setVKL_low(){
		btn5V.setText(TEXTs.ON.getText());
		lbl5Vs.setBackground(Color.LIGHT_GRAY);
		//btnMain4V.setEnabled(false);
		//btnReserve4V.setEnabled(false);
	}


	void setMain4VL_high(){
		btnMain4V.setText(TEXTs.OFF.getText());
		lblMain4V.setBackground(Color.GREEN);
		//btnReserve4V.setEnabled(false);
		//btn5V.setEnabled(false);
	}

	void setMain4VL_low(){
		btnMain4V.setText(TEXTs.ON.getText());
		lblMain4V.setBackground(Color.LIGHT_GRAY);
		//btnReserve4V.setEnabled(true);
		//btn5V.setEnabled(true);
	}


	void setReserve4VL_high(){
		btnReserve4V.setText(TEXTs.OFF.getText());
		lblReserve4V.setBackground(Color.GREEN);
		//btnMain4V.setEnabled(false);
		//btn5V.setEnabled(false);
	}

	void setReserve4VL_low(){
		btnReserve4V.setText(TEXTs.ON.getText());
		lblReserve4V.setBackground(Color.LIGHT_GRAY);
		//btnMain4V.setEnabled(true);
		//btn5V.setEnabled(true);
	}

}
