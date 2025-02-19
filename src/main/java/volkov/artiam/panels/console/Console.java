package volkov.artiam.panels.console;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@NoArgsConstructor
@Getter @Setter
public class Console implements PropertyChangeListener {

    ConsoleView pnl = new ConsoleView();

    public void propertyChange(PropertyChangeEvent evt) {
    	String propertyName = evt.getPropertyName();
    	if (propertyName.equals("news") ) {
    		String strFromArduino =  (String)evt.getNewValue();
            pnl.textAreaRx.append(" RX: " + strFromArduino + "\n");
    	} else if(propertyName.equals("command") ) {
            String strToArduino =  (String)evt.getNewValue();
            pnl.textAreaTx.append(" TX: " + strToArduino + "\n");
    	} 
    }
    
}
