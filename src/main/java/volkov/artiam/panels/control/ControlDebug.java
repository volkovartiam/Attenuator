package volkov.artiam.panels.control;

import volkov.artiam.printers.ConsolePrinter;

import javax.swing.*;
import java.awt.*;

public class ControlDebug extends JFrame   {

	Control control	= new Control();

	//ControlView view = new ControlView();
	JPanel pnl = control.getPnl();

	int xSize = 1000;
	int ySize = 500;

	ControlDebug() {
		control.setPrinter(new ConsolePrinter());
		control.setTm("yyyyTM_ATT;63;xxx");
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
				ControlDebug frame = new ControlDebug();
				frame.setVisible(true);
			}
		});
	}

}
