package volkov.artiam.panels.port;

import javax.swing.*;
import java.awt.*;

public class PortDebugg extends JFrame {

	int xSize = 850;
	int ySize = 100;

	PortDebugg(Port port) {

		JPanel pnl = port.pnl;
		add(pnl);

		setTitle("Для отладки панели подключения/отключения COM-порта") ;
		setMinimumSize(new Dimension(xSize, ySize));

		String [] arr = {"1", "2", "3"};
		port.setPorts(arr);

		pack() ;
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);
	}

	PortDebugg(Port port, boolean isDisconnected){
		port.setConnectedOrDisconnectedView(isDisconnected);
		new PortDebugg(port);
	}

	public static void main ( String[] args ) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PortDebugg frame = new PortDebugg(new Port(), true);
				frame.setVisible(true);

				PortDebugg frame2 = new PortDebugg( new Port(), false);
				frame2.setVisible(true);
			}
		});
	}
}
