package volkov.artiam.panels.portAndArduino;

import javax.swing.*;
import java.awt.*;

public class PortAndArduinoDebug extends JFrame {

	int sizeX = 910	 ;
	int sizeY = 150 ;

	PortAndArduino portAndArduino = new PortAndArduino();

	PortAndArduinoDebug() {

		setTitle("Программа для отладки управления Arduino") ;
		setResizable(false);
		setMinimumSize(new Dimension(sizeX, sizeY ));

		getContentPane().add(portAndArduino.getPnl() );

		pack() ;
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);
	}

	public static void main ( String[] args ) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PortAndArduinoDebug frame = new PortAndArduinoDebug();
				frame.setVisible(true);
			}
		});
	}
}
