package volkov.artiam.mainsPanels.mainPanel;

import volkov.artiam.arduino.ArduinoAccess;

import javax.swing.*;
import java.awt.*;

public class PnlMainDebug extends JFrame {

	PnlMain pnl = new PnlMain();

	int xSize = 900;
	int ySize = 680;

	PnlMainDebug() {

		ArduinoAccess.getInstance().addPropertyChangeListener(pnl.console);
		ArduinoAccess.getInstance().addPropertyChangeListener(pnl.channelMain);

		setTitle("Для отладки всей панели управления") ;
		setMinimumSize(new Dimension(xSize, ySize));
		add(pnl);

		pack() ;
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);

		pnl.setPrinter( ArduinoAccess.getInstance() );

		//pnl.setEnabled(false);
	}
	
	
	public static void main ( String[] args ) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PnlMainDebug frame = new PnlMainDebug();
				frame.setVisible(true);
			}
		});
	}
}
