package volkov.artiam.panels.control;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.TEXTs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter 
@Setter
public class Supplies implements ActionListener{

 	JButton btn5V = new JButton("ON");
	JButton btnMain4V = new JButton("ON");
	JButton btnReserve4V = new JButton("ON");

	JLabel lblSupply5Vs = new JLabel("���-1");
	JLabel lblSupply4vMain = new JLabel("4V_���1");
	JLabel lblSupply4vReserve = new JLabel("4V_���1");

	SupliesView pnl = new SupliesView();
	SuppliesModel model = new SuppliesModel();

	public Supplies() {

		btn5V = pnl.btn5V;
		btnMain4V = pnl.btnMain4V;
		btnReserve4V = pnl.btnReserve4V;
		JLabel lbl5Vs = pnl.lblSupply5Vs;
		JLabel lblMain4V = pnl.lblSupply4vMain;
		JLabel lblReserve4V = pnl.lblSupply4vReserve;
/*
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
*/
	}


	// ��������� ������� � ������ (��� ��������� �������)
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

	// ������ 5� 	
		if(e.getSource() == btn5V) {

		}
		
	// ������ 4� ��������� ������
		if(e.getSource() == btnMain4V) {

		}
		
	// ������ 4� ���������� ������
		if(e.getSource() == btnReserve4V) {

		}

	}

}
