package volkov.artiam.mainsPanels.control;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.TEXTs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter @Setter
public class Supplies implements ActionListener{

 	JButton btn5V = new JButton("ON");
	JButton btnMain4V = new JButton("ON");
	JButton btnReserve4V = new JButton("ON");

	JLabel lblSupply5Vs = new JLabel("ВКЛ-1");
	JLabel lblSupply4vMain = new JLabel("4V_осн1");
	JLabel lblSupply4vReserve = new JLabel("4V_рез1");

	SupliesView pnl = new SupliesView();
	SuppliesModel model = new SuppliesModel();

	public Supplies() {

		btn5V = pnl.getBtn5V();
		btnMain4V = pnl.getBtnMain4V();
		btnReserve4V = pnl.getBtnReserve4V();
		JLabel lbl5Vs = pnl.getLbl5VsIndicator();
		JLabel lblMain4V = pnl.getLblMain4vIndicator();
		JLabel lblReserve4V = pnl.getLblReserve4vIndicator();

		lblSupply5Vs = pnl.getLblSupply5Vs();
		lblSupply4vMain = pnl.getLblSupply4vMain();
		lblSupply4vReserve = pnl.getLblSupply4vReserve();

		model.setBtn5V(btn5V);
		model.setBtnMain4V(btnMain4V);
		model.setBtnReserve4V(btnReserve4V);
		model.setLbl5Vs(lbl5Vs);
		model.setLblMain4V(lblMain4V);
		model.setLblReserve4V(lblReserve4V);
		model.init();

		btn5V.addActionListener(this);
		btnMain4V.addActionListener(this);
		btnReserve4V.addActionListener(this);
	}


	// Обработка событий с кнопок (для индикации питания)
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

	// Кнопка 5В 	
		if(e.getSource() == btn5V) {
			if(actionCommand.equals(TEXTs.ON.getText())) {
				model.setVKL_high( );
			} else if (actionCommand.equals(TEXTs.OFF.getText() )) {
				model.setVKL_low();
			}
		}
		
	// Кнопка 4В основного канала
		if(e.getSource() == btnMain4V) {
			if(actionCommand.equals(TEXTs.ON.getText())) {
				model.setMain4VL_high();
			} else if (actionCommand.equals(TEXTs.OFF.getText())) {
				model.setMain4VL_low();
			}
		}
		
	// Кнопка 4В резервного канала
		if(e.getSource() == btnReserve4V) {
			if(actionCommand.equals(TEXTs.ON.getText())) {
				model.setReserve4VL_high();
			} else if (actionCommand.equals(TEXTs.OFF.getText())) {
				model.setReserve4VL_low();
			}
		}

	}

}
