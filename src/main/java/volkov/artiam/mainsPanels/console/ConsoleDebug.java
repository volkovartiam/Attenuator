package volkov.artiam.mainsPanels.console;

import javax.swing.*;
import java.awt.*;

public class ConsoleDebug extends JFrame   {

	Console console = new Console();
	JPanel pnl = console.getPnl();

	int xSize = 1000;
	int ySize = 150;

	ConsoleDebug() {

		setTitle("Для отладки панели консоли") ;
		setMinimumSize(new Dimension(xSize, ySize));
		add(pnl);

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
				ConsoleDebug frame = new ConsoleDebug();
				frame.setVisible(true);
			}
		});
	}

}
