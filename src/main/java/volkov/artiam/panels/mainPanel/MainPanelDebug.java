package volkov.artiam.panels.mainPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanelDebug extends JFrame {

	int xSize = 910;
	int ySize = 500;

	MainPanelDebug(MainPanel mainPanel) {

		JPanel pnl = mainPanel.pnl;

		setTitle("Для отладки всей панели управления") ;
		setMinimumSize(new Dimension(xSize, ySize));
		add(pnl);

		pack() ;
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);
	}

	MainPanelDebug(boolean isConnected){
		MainPanel mainPanel = new MainPanel();
		mainPanel.setConnectedOrDisconnectedView(isConnected);
		new MainPanelDebug(mainPanel);
	}


	public static void main ( String[] args ) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainPanelDebug frame = new MainPanelDebug(false);
				frame.setVisible(true);

				MainPanelDebug frame2 = new MainPanelDebug(true);
				frame.setVisible(true);
			}
		});
	}
}
