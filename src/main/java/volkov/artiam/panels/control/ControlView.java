package volkov.artiam.panels.control;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter @Setter
public class ControlView extends JPanel {

	JCheckBox chPositive = new JCheckBox("chPositive");
	JCheckBox chNegative = new JCheckBox("chNegative");
	JButton btnSetAtt = new JButton("btnSetAtt");

	JLabel lblAttVal = new JLabel("15.5");
	JLabel lblAttTM = new JLabel("ТМ = 15.5");
	JSlider slider = new JSlider();
	
	public ControlView() {
	// Установка параметров панели
		setLayout(null);
		setSize(900, 10);
		setBackground(UIManager.getColor("Button.background"));
		setBorder(new EmptyBorder(0, 0, 0, 0));

		chPositive = new JCheckBox("+3,3В");
		chPositive.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chPositive.setBounds(200, 11, 140, 23);
		add(chPositive);
		
		lblAttVal.setOpaque(true);
		//lblAttVal.setBorder(BorderFactory.createLineBorder(Color.gray));
		lblAttVal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttVal.setBounds(440, 50, 50, 20);
		add(lblAttVal);

		lblAttTM.setOpaque(true);
		//lblAttTM.setBorder(BorderFactory.createLineBorder(Color.gray));
		lblAttTM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAttTM.setBounds(700, 50, 100, 20);
		add(lblAttTM);

		chNegative = new JCheckBox("-3,3В");
		chNegative.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chNegative.setBounds(70, 11, 133, 23);
		add(chNegative);
		
		btnSetAtt = new JButton("Установить");
		btnSetAtt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSetAtt.setBounds(510, 50, 140, 23);
		add(btnSetAtt);

		slider = new JSlider(0, 64, 64);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 12));
		slider.setBounds(60, 45, 350, 50);

		slider.setPaintTrack(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		/*
		slider.setMajorTickSpacing();
		slider.setMinorTickSpacing();
		*/
		add(slider);

	}
}
