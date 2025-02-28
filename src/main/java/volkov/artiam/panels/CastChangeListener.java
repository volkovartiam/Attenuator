package volkov.artiam.panels;

import lombok.Getter;
import lombok.Setter;
import volkov.artiam.datas.DATAS;
import volkov.artiam.printers.IPrinter;
import volkov.artiam.printers.NoPrinter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter @Setter
public class CastChangeListener implements PropertyChangeListener {

    public String news = DATAS.PCL_NEWS.toString();
    public String commands = DATAS.PCL_COMMAND.toString();
    public String tm = DATAS.PCL_TM.toString();

    public IPrinter printer = new NoPrinter();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if (propertyName.equals(news) ) {

        }
        else if(propertyName.equals(commands) ) {

        }
        else if(propertyName.equals(tm) ) {

        }
    }
}
