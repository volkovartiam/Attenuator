package volkov.artiam.panels.mainPanel;

import volkov.artiam.arduino.PrintImpl;
import volkov.artiam.panels.att.Att;
import volkov.artiam.panels.console.Console;
import volkov.artiam.panels.control.Control;
import volkov.artiam.panels.portAndArduino.PortAndArduino;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class PnlMain extends JPanel {





	PortAndArduino port = new PortAndArduino();
	Control control = new Control();
	Att att = new Att();

	public Console console = new Console();

	JPanel attPnl = att.getPnl();


	JPanel controlPnl = control.getPnl();
	JPanel pnlPort = port.getPnl();
	JPanel pnlConsole = console.getPnl();

	PnlMainHandler pnlMainHandler = new PnlMainHandler();


	JButton btnConnect = port.btnConnect;

	DisconnectChecker disconnectChecker = new DisconnectChecker();


	public PnlMain() {
	// Установка параметров панели
		setLayout(null);
		setBackground(UIManager.getColor("Button.background"));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
/**/
		pnlPort.setBounds(0, 0, 900, 45);
		add(pnlPort);

		controlPnl.setBounds(0, 60, 900, 80);
		add(controlPnl);
/**/
		attPnl.setBounds(70, 170, 900, 200);
		//attPnl.setBorder( new EtchedBorder());
		add(attPnl);
/**/
		pnlConsole.setBounds(5, 380, 900, 60);
		add(pnlConsole);
/**/
		//setChannelMain();
		initHandler();

		disconnectChecker.setBtnConnect(btnConnect);
		disconnectChecker.init(this);
	}



	public void setPrinter(PrintImpl printer){

		//channelMain.setPrinter(printer);
	}

	private void initHandler(){
		pnlMainHandler = new PnlMainHandler();


		pnlMainHandler.setBtnConnect(btnConnect);
		pnlMainHandler.init();
	}

	public void setEnabled(boolean isEnabled){
		//channelMain.setEnable(isEnabled);
		for(BtnState state : pnlMainHandler.getButtonStates()){
			if(state.isEnable() ){
				state.getBtn().setEnabled(isEnabled);
			}
		}
	}

}
