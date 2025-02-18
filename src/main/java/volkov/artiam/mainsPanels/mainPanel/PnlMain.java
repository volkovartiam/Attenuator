package volkov.artiam.mainsPanels.mainPanel;

import volkov.artiam.arduino.PrintImpl;
import volkov.artiam.datas.*;
import volkov.artiam.mainsPanels.channel.Channel;
import volkov.artiam.mainsPanels.channel.Printer;
import volkov.artiam.mainsPanels.console.Console;
import volkov.artiam.mainsPanels.portAndArduino.PortAndArduino;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class PnlMain extends JPanel {

	public Channel channelMain = new Channel();
	//Port port = new Port();
	PortAndArduino port = new PortAndArduino();
	public Console console = new Console();

	JPanel mainPnl = channelMain.getView();
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

	// Панель выбора СОМ-порта
		pnlPort.setBounds(0, 0, 900, 45);
		pnlPort.setBorder(null);
		add(pnlPort);

	// Панель основного канала управления
		mainPnl.setBounds(0, 290, 900, 250);
		add(mainPnl);
		
	// Панель с консолью отправленных и принятых команд	
		pnlConsole.setBounds(0, 540, 900, 60);
		add(pnlConsole);

		setChannelMain();
		initHandler();

		disconnectChecker.setBtnConnect(btnConnect);
		disconnectChecker.init(this);
	}

	private void setChannelMain(){
		channelMain.setTag(TEXTs.OK.getText());
		channelMain.setLabelsText( "Канал управления основной" ,
				"ВКЛ-1" ,
				"4V-осн1" ,
				"4V-рез1"                    );
		channelMain.setPrinter(new Printer() );
	}

	public void setPrinter(PrintImpl printer){
		channelMain.setPrinter(printer);
	}

	private void initHandler(){
		pnlMainHandler = new PnlMainHandler();


		pnlMainHandler.setBtnConnect(btnConnect);
		pnlMainHandler.init();
	}

	public void setEnabled(boolean isEnabled){
		channelMain.setEnable(isEnabled);
		for(BtnState state : pnlMainHandler.getButtonStates()){
			if(state.isEnable() ){
				state.getBtn().setEnabled(isEnabled);
			}
		}
	}

}
