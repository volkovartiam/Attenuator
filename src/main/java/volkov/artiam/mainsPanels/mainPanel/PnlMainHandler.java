package volkov.artiam.mainsPanels.mainPanel;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.TEXTs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@Setter @Getter
public class PnlMainHandler implements ActionListener {

	JButton btn5V_OK;
	JButton btnMain4V_OK;
	JButton btnReserve4V_OK;
	JButton btn5V_RK;
	JButton btnMain4V_RK;
	JButton btnReserve4V_RK;
	JButton btnConnect;

	ArrayList<BtnState> buttonStates = new ArrayList<>();
	BtnState btn5V_OK_state;
	BtnState btnMain4V_OK_state;
	BtnState btnReserve4V_OK_state;
	BtnState btn5V_RK_state;
	BtnState btnMain4V_RK_state;
	BtnState btnReserve4V_RK_state;

	String ON = TEXTs.ON.getText();
	String OFF = TEXTs.OFF.getText();
	String CONNECT = TEXTs.CONNECT.getText();
	String DISCONNECT = TEXTs.DISCONNECT.getText();

	boolean isSomethingFrom4VisOn = false;

	void init(){

		btnConnect.addActionListener(this);



	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		JButton btnSource = (JButton) e.getSource();

		update();
		//btn5V_OK
		if (btnSource.equals(btn5V_OK)) {
			if (actionCommand.equals(ON)) {
				set_btn5V_OK_state(true);
			}
			if (actionCommand.equals(OFF)) {
				set_btn5V_OK_state(false);
			}
		}
		//btn5V_RK
		if (btnSource.equals(btn5V_RK)) {
			if (actionCommand.equals(ON)) {
				set_btn5V_RK_state(true);
			}
			if (actionCommand.equals(OFF)) {
				set_btn5V_RK_state(false);
			}
		}

		//btnMain4V_OK
		if (btnSource.equals(btnMain4V_OK)) {
			if (actionCommand.equals(ON)) {
				set_btnMain4V_OK_state(true);
			}
			if (actionCommand.equals(OFF)) {
				set_btnMain4V_OK_state(false);
			}
		}
		//btnReserve4V_OK
		if (btnSource.equals(btnReserve4V_OK)) {
			if (actionCommand.equals(ON)) {
				set_btnReserve4V_OK_state(true);
			}
			if (actionCommand.equals(OFF)) {
				set_btnReserve4V_OK_state(false);
			}
		}

		//btnMain4V_RK
		if (btnSource.equals(btnMain4V_RK)) {
			if (actionCommand.equals(ON)) {
				set_btnMain4V_RK_state(true);
			}
			if (actionCommand.equals(OFF)) {
				set_btnMain4V_RK_state(false);
			}
		}
		//btnReserve4V_RK
		if (btnSource.equals(btnReserve4V_RK)) {
			if (actionCommand.equals(ON)) {
				set_btnReserve4V_RK_state(true);
			}
			if (actionCommand.equals(OFF)) {
				set_btnReserve4V_RK_state(false);
			}
		}

		//btnConnect
		if (btnSource.equals(btnConnect)) {
			if (actionCommand.equals(CONNECT)) {
				btn5V_OK.setEnabled(true);
				btn5V_RK.setEnabled(true);
			}
			if (actionCommand.equals(DISCONNECT)) {
				btn5V_OK.setEnabled(false);
				btn5V_RK.setEnabled(false);
			}
		}


	}

	void update(){
		for(BtnState btnState: buttonStates){
			if(btnState.getBtn().isEnabled()){
				btnState.setEnable(true);
			}
		}
	}

	void set_btn5V_OK_state(boolean state){
		btn5V_OK_state.setOn(state);
		if( btn5V_OK_state.isOn() ){
			set4Vs_OK_Enabled(!isSomethingFrom4VisOn);
		} else {
			set4Vs_OK_Enabled(false);
		}
	}

	private void set4Vs_OK_Enabled(boolean isEnabled){
		btnMain4V_OK_state.setEnabled(isEnabled);
		btnReserve4V_OK_state.setEnabled(isEnabled);
	}


	void set_btn5V_RK_state(boolean state){
		btn5V_RK_state.setOn(state);
		if( btn5V_RK_state.isOn()   ){
			set4Vs_RK_Enabled(!isSomethingFrom4VisOn);
		} else {
			set4Vs_RK_Enabled(false);
		}
	}
	private void set4Vs_RK_Enabled(boolean isEnabled){
		btnMain4V_RK_state.setEnabled(isEnabled);
		btnReserve4V_RK_state.setEnabled(isEnabled);
	}


	void set_btnMain4V_OK_state(boolean state){
		btnMain4V_OK_state.setOn(state);
		if(state){
			if( !isSomethingFrom4VisOn ){
				isSomethingFrom4VisOn = true;
				btn5V_OK_state.setEnabled(false);
				btnReserve4V_OK_state.setEnabled(false);
				set4Vs_RK_Enabled(false);
			}
		} else{
			isSomethingFrom4VisOn = false;
			btn5V_OK_state.setEnabled(true);
			btnReserve4V_OK_state.setEnabled(true);
			set4Vs_RK_Enabled(btn5V_RK_state.isOn());
		}
	}


	private void set_btnReserve4V_OK_state(boolean state){
		btnReserve4V_OK_state.setOn(state);
		if(state){
			if( !isSomethingFrom4VisOn ){
				isSomethingFrom4VisOn = true;
				btn5V_OK_state.setEnabled(false);
				btnMain4V_OK_state.setEnabled(false);
				set4Vs_RK_Enabled(false);
			}
		} else{
			isSomethingFrom4VisOn = false;
			btn5V_OK_state.setEnabled(true);
			btnMain4V_OK_state.setEnabled(true);
			set4Vs_RK_Enabled(btn5V_RK_state.isOn());
		}
	}


	void set_btnMain4V_RK_state(boolean state){
		btnMain4V_RK_state.setOn(state);
		if(state){
			if( !isSomethingFrom4VisOn ){
				isSomethingFrom4VisOn = true;
				btn5V_RK_state.setEnabled(false);
				btnReserve4V_RK_state.setEnabled(false);
				set4Vs_OK_Enabled(false);
			}
		} else{
			isSomethingFrom4VisOn = false;
			btn5V_RK_state.setEnabled(true);
			btnReserve4V_RK_state.setEnabled(true);
			set4Vs_OK_Enabled(btn5V_OK_state.isOn());
		}
	}


	private void set_btnReserve4V_RK_state(boolean state){
		btnReserve4V_RK_state.setOn(state);
		if(state){
			if( !isSomethingFrom4VisOn ){
				isSomethingFrom4VisOn = true;
				btn5V_RK_state.setEnabled(false);
				btnMain4V_RK_state.setEnabled(false);
				set4Vs_OK_Enabled(false);
			}
		} else{
			isSomethingFrom4VisOn = false;
			btn5V_RK_state.setEnabled(true);
			btnMain4V_RK_state.setEnabled(true);
			set4Vs_OK_Enabled(btn5V_OK_state.isOn());
		}
	}



}
