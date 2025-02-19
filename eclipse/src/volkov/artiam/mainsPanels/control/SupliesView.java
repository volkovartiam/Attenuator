package volkov.artiam.panels.control;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter 
@Setter
public class SupliesView extends JPanel {

	JButton btn5V = new JButton("btn5V");
	JButton btnMain4V = new JButton("btnMain4V");
	JButton btnReserve4V = new JButton("btnReserve4V");

	JLabel lbl5VsIndicator = new JLabel("");
	JLabel lblReserve4vIndicator = new JLabel("");
	JLabel lblMain4vIndicator = new JLabel("");

	JLabel lblSupply5Vs = new JLabel("���-1");
	JLabel lblSupply4vMain = new JLabel("4V_���1");
	JLabel lblSupply4vReserve = new JLabel("4V_���1");

	public SupliesView() {
	// ��������� ���������� ������
		setLayout(null);
		setSize(500, 80);
		setBackground(UIManager.getColor("Button.background"));
		setBorder(new EmptyBorder(0, 0, 0, 0));

	// ���-1
		lblSupply5Vs = new JLabel("���-1");
		lblSupply5Vs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupply5Vs.setBounds(250, 15, 190, 14);
		add(lblSupply5Vs);
		
		btn5V = new JButton("���");
		btn5V.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn5V.setBounds(310, 11, 140, 23);
		add(btn5V);
		
		lbl5VsIndicator.setOpaque(true);
		lbl5VsIndicator.setBorder(BorderFactory.createLineBorder(Color.gray));
		lbl5VsIndicator.setBounds(460, 12, 20, 20);
		add(lbl5VsIndicator);

	// 4V_���1
		lblSupply4vMain = new JLabel("4V_���1");
		lblSupply4vMain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupply4vMain.setBounds(15, 54, 92, 14);
		add(lblSupply4vMain);

		btnMain4V = new JButton("���");
		btnMain4V.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMain4V.setBounds(70, 50, 133, 23);
		add(btnMain4V);
		
		lblMain4vIndicator.setOpaque(true);
		lblMain4vIndicator.setBorder(BorderFactory.createLineBorder(Color.gray));
		lblMain4vIndicator.setBounds(215, 51, 20, 20);	//266
		add(lblMain4vIndicator);

	// 4V_���1
		lblSupply4vReserve = new JLabel("4V_���1");
		lblSupply4vReserve.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSupply4vReserve.setBounds(250, 54, 92, 14);
		add(lblSupply4vReserve);

		btnReserve4V = new JButton("���");
		btnReserve4V.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReserve4V.setBounds(310, 50, 140, 23);
		add(btnReserve4V);
		
		lblReserve4vIndicator.setOpaque(true);
		lblReserve4vIndicator.setBorder(BorderFactory.createLineBorder(Color.gray));
		lblReserve4vIndicator.setBounds(460, 51, 20, 20);
		add(lblReserve4vIndicator);

	}
}
