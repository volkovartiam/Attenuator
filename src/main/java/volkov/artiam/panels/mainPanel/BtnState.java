package volkov.artiam.panels.mainPanel;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter @Setter
public class BtnState {

    private final JButton btn;
    private boolean isOn;
    private boolean isEnable;

    BtnState(JButton btn, boolean isOn, boolean isEnable){
        this.btn = btn;
        this.isOn = isOn;
        this.isEnable = isEnable;
        btn.setEnabled(isEnable);
    }

    public void setEnabled(boolean enable) {
        isEnable = enable;
        btn.setEnabled(enable);
    }

}
