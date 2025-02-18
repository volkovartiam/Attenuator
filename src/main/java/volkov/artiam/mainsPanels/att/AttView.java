package volkov.artiam.mainsPanels.att;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class AttView extends JPanel{

	ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
	JLabel lblAttDef;

	public AttView() {

	// Установка параметров панели
		setLayout(null);
		setSize(100, 170);
		setBackground(UIManager.getColor("Button.background"));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		
	// Размещение чек-боксов на панели
		JCheckBox checkBox0 = new JCheckBox("0.0 dB");
		checkBox0.setBounds(14, 17, 80, 20);
		add(checkBox0);

		JCheckBox checkBox1 = new JCheckBox("0.5 dB");
		checkBox1.setBounds(14, 38, 80, 20);
		add(checkBox1);

		JCheckBox checkBox2 = new JCheckBox("1.0 dB");
		checkBox2.setBounds(14, 59, 80, 20);
		add(checkBox2);

		JCheckBox checkBox3 = new JCheckBox("2.0 dB");
		checkBox3.setBounds(14, 80, 80, 20);
		add(checkBox3);

		JCheckBox checkBox4 = new JCheckBox("4.0 dB");
		checkBox4.setBounds(14, 101, 80, 20);
		add(checkBox4);

		JCheckBox checkBox5 = new JCheckBox("8.0 dB");
		checkBox5.setBounds(14, 122, 80, 20);
		add(checkBox5);

		JCheckBox checkBox6 = new JCheckBox("15.5.0 dB");
		checkBox6.setBounds(14, 143, 80, 20);
		add(checkBox6);

		checkBoxes.add(checkBox0);
		checkBoxes.add(checkBox1);
		checkBoxes.add(checkBox2);
		checkBoxes.add(checkBox3);
		checkBoxes.add(checkBox4);
		checkBoxes.add(checkBox5);
		checkBoxes.add(checkBox6);

		for (JCheckBox jCb: checkBoxes) {
			jCb.setFont(new Font("Tahoma", Font.PLAIN, 12));
			jCb.setHorizontalAlignment(SwingConstants.LEFT);
		}

	// Метка со знаком суммы
		JLabel lblSum = new JLabel("\u2211 = ");
		lblSum.setHorizontalAlignment(SwingConstants.CENTER);
		lblSum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSum.setBounds(10, 0, 30, 14);
		add(lblSum);
		
	// Текущее значение аттенюации	
		lblAttDef = new JLabel("15.5 dB");
		lblAttDef.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttDef.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAttDef.setBounds(25, 0, 76, 14);
		add(lblAttDef);
	}
}
