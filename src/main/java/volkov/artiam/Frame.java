package volkov.artiam;

import volkov.artiam.arduino.ArduinoAccess;
import volkov.artiam.panels.mainPanel.PnlMain;

import javax.swing.*   ;
import java.awt.*   ;

public class Frame extends JFrame {

	int sizeX = 910	 ;
	int sizeY = 500 ;
	PnlMain pnlMain = new PnlMain();

	Frame() {

		ArduinoAccess.getInstance().addPropertyChangeListener(pnlMain.console);
		//ArduinoAccess.getInstance().addPropertyChangeListener(pnlMain.channelMain);
		pnlMain.setPrinter( ArduinoAccess.getInstance() );

		setTitle("Программа управления аттенюатора") ;
		setResizable(false);
		setMinimumSize(new Dimension(sizeX, sizeY ));
		getContentPane().add(pnlMain);

		pack() ;
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);

	}
}
