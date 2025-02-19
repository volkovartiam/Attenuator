package volkov.artiam.panels.port;

import javax.swing.*;
import java.awt.*;

public class PortDebugg extends JFrame {

	Port port = new Port();
	int xSize = 850;
	int ySize = 100;


	PortDebugg() {

		setTitle("Для отладки панели подключения/отключения COM-порта") ;
		setMinimumSize(new Dimension(xSize, ySize));
		add(port.pnl);

		String [] arr = {"1", "2", "3"};
		port.setNewComPorts(arr);

		port.isConnected(true);
		//port.isConnected(false);

		String [] arr2 = {"5", "6", "7"};
		port.setNewComPorts(arr);

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
				PortDebugg frame = new PortDebugg();
				frame.setVisible(true);
			}
		});
	}
}
