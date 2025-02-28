package volkov.artiam;

import javax.swing.*   ;
import java.awt.*   ;

public class Frame extends JFrame {

	int sizeX = 910	 ;
	int sizeY = 500 ;
	MainPanelController controller = new MainPanelController();
	JPanel pnl = controller.mainPanel.getPnl();

	Frame() {

		setTitle("Программа управления аттенюатора") ;
		setResizable(false);
		setMinimumSize(new Dimension(sizeX, sizeY ));
		getContentPane().add(pnl);

		pack() ;
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);

	}
}
