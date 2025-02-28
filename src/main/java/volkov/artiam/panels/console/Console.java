package volkov.artiam.panels.console;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import volkov.artiam.panels.CastChangeListener;

import java.beans.PropertyChangeEvent;

@NoArgsConstructor
@Getter @Setter
public class Console extends CastChangeListener {

    ConsoleView pnl = new ConsoleView();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    	String propertyName = evt.getPropertyName();
    	if (propertyName.equals(news) ) {
    		String fromArduino =  (String)evt.getNewValue();
            pnl.textAreaLeft.append(" RX: " + fromArduino + "\n");
    	}
        else if(propertyName.equals(commands) ) {
            String toArduino =  (String)evt.getNewValue();
            pnl.textAreaRight.append(" TX: " + toArduino + "\n");
    	}
        else if(propertyName.equals(tm) ) {
            String tmDatas =  (String)evt.getNewValue();
            printer.print(tmDatas + "TM_DATAS");
        }
    }

}
