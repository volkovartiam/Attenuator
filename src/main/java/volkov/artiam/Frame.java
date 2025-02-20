package volkov.artiam;

import volkov.artiam.panels.mainPanel.MainPanel;

import javax.swing.*   ;
import java.awt.*   ;

public class Frame extends JFrame {

	int sizeX = 910	 ;
	int sizeY = 500 ;
	MainPanel pnlMain = new MainPanel();
	JPanel pnl = pnlMain.getPnl();

	Frame() {

		//ArduinoAccess.getInstance().addPropertyChangeListener(pnlMain.console);
		//ArduinoAccess.getInstance().addPropertyChangeListener(pnlMain.channelMain);
		//pnlMain.setPrinter( ArduinoAccess.getInstance() );

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
