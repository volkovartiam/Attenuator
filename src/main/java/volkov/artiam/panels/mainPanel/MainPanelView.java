package volkov.artiam.panels.mainPanel;

import volkov.artiam.panels.att.Att;
import volkov.artiam.panels.console.Console;
import volkov.artiam.panels.control.Control;
import volkov.artiam.panels.port.Port;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class MainPanelView extends JPanel {

	public Port port = new Port();
	public Control control = new Control();
	public Att att = new Att();
	public Console console = new Console();

	JPanel pnlPort = port.getPnl();
	JPanel controlPnl = control.getPnl();
	JPanel attPnl = att.getPnl();
	JPanel pnlConsole = console.getPnl();

	public MainPanelView() {

		setLayout(null);
		setBackground(UIManager.getColor("Button.background"));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		pnlPort.setBounds(0, 10, 900, 45);
		add(pnlPort);

		controlPnl.setBounds(0, 60, 900, 80);
		add(controlPnl);

		attPnl.setBounds(70, 170, 900, 200);
		add(attPnl);

		pnlConsole.setBounds(5, 380, 900, 60);
		add(pnlConsole);

	}

}
