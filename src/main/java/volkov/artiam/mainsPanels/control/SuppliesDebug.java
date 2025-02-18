package volkov.artiam.mainsPanels.control;

import javax.swing.*;
import java.awt.*;

public class SuppliesDebug extends JFrame   {

	Supplies supplies = new Supplies();
	JPanel pnl = supplies.getPnl();

	int xSize = 1000;
	int ySize = 150;

	SuppliesDebug() {
		setTitle("Для отладки панели управления питанием") ;
		setMinimumSize(new Dimension(xSize, ySize));
		add(pnl);

		pack();
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);

	}

	public static void main ( String[] args ) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SuppliesDebug frame = new SuppliesDebug();
				frame.setVisible(true);
			}
		});
	}

}
