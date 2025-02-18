package volkov.artiam.mainsPanels.att;

import java.awt.Dimension;

import javax.swing.*;

public class AttDebug extends JFrame {

	Att att = new Att();
	JPanel pnl = att.getPnl();
	int xSize = 200;
	int ySize = 220;

	AttDebug() {

		setTitle("Для отладки панели аттенюаторов") ;
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
				AttDebug frame = new AttDebug();
				frame.setVisible(true);
			}
		});
	}
}
