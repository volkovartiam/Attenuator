package volkov.artiam.panels.port;

import lombok.Getter;
import lombok.Setter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@Getter @Setter
public class PortView extends JPanel {

	JButton btnConnect;
	JButton btnLed;
	JButton btnUpdate;
	
	JComboBox<String> comboPortSelection; 
	JLabel lblLed = new JLabel("");
	
	public PortView() {
	// Установка параметров панели
		setLayout(null);
		setSize(900, 40);
		setBackground(UIManager.getColor("Button.background"));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		
	// Для подключения/отключения COM-порта 						
		btnConnect = new JButton("Подключение");					
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConnect.setBounds(70, 11, 125, 23);
		add(btnConnect);
		
	// кнопка и метка включения светодиода пульта
		btnLed = new JButton("Контроль ВКЛ");
		btnLed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLed.setBounds(515, 11, 125, 23);
		add(btnLed);

		lblLed.setOpaque(true);
		lblLed.setBorder(BorderFactory.createLineBorder(Color.gray));
		lblLed.setBounds(655, 12, 20, 20);
		add(lblLed);
		
	// Combobox с доступными COM-портами
		comboPortSelection =  new JComboBox<>(); 
		comboPortSelection.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboPortSelection.setBounds(230, 12, 125, 20);
		add(comboPortSelection);
		
	// Кнока для обновления доступных COM-портов	
		btnUpdate = new JButton("");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdate.setBounds(380, 11, 30, 23);

		try {
	        Image image = ImageIO.read(getClass().getResourceAsStream("/images/update.png"));
	        image = image.getScaledInstance(btnUpdate.getWidth(), btnUpdate.getHeight(), Image.SCALE_DEFAULT);
	        ImageIcon icon=new ImageIcon(image);
		    btnUpdate.setIcon(icon);
		  } catch (Exception ex) {
		    System.out.println( this.getClass().getName() );
		    System.out.println( "Image not finded " + ex);
		  }
		add(btnUpdate);
	}
}
