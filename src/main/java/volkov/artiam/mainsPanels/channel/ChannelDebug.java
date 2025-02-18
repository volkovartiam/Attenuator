package volkov.artiam.mainsPanels.channel;

import volkov.artiam.datas.TEXTs;


import javax.swing.*;
import java.awt.*;

public class ChannelDebug extends JFrame {

	Channel channel = new Channel();
	JPanel pnl = channel.getView();

	Channel channelReserve = new Channel();
	JPanel pnlReserve = channelReserve.getView();

	int xSize = 900;
	int ySize = 600;

	ChannelDebug() {

		setTitle("Для отладки панели канала управления") ;
		setMinimumSize(new Dimension(xSize, ySize));

		JPanel framePanel = new JPanel();
		framePanel.setLayout(new GridLayout(2, 1));
		////////////////////////////////////////////////////////////////////////////
		channelReserve.setTag(TEXTs.RK.getText());
		channelReserve.setLabelsText( "Канал управления резервный" ,
				"ВКЛ-2" ,
				"4V-осн2" ,
				"4V-рез2"                    );
		channelReserve.setPrinter(new Printer() );

		framePanel.add(pnlReserve);
		pnlReserve.setEnabled(false);

		////////////////////////////////////////////////////////////////////////////
		channel.setTag(TEXTs.OK.getText());
		channel.setLabelsText( "Канал управления основной" ,
				"ВКЛ-1" ,
				"4V-осн1" ,
				"4V-рез1"                    );


		channel.setPrinter(new Printer() );


		framePanel.add(pnl);
		pnl.setEnabled(false);
		////////////////////////////////////////////////////////////////////////////
		add(framePanel);

		pack() ;
		setLocationRelativeTo( null ) ;
		setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
		setVisible(true) ;
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);

		channel.setEnable(false);
	}


	public static void main ( String[] args ) {
		SwingUtilities.invokeLater(() -> {
			ChannelDebug frame = new ChannelDebug();
			frame.setVisible(true);
		});
	}


}
