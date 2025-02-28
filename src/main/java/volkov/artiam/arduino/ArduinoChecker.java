package volkov.artiam.arduino;

import com.fazecast.jSerialComm.SerialPortDataListener;
import volkov.artiam.arduino.listeners.ArduinoListener;
import volkov.artiam.arduino.listeners.Listener_Data_Available;
import volkov.artiam.arduino.listeners.Listener_Port_Disconnected;
import volkov.artiam.printers.ConsolePrinter;
import volkov.artiam.printers.IPrinter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class ArduinoChecker{

    ArduinoServiceWithListeners arduino = ArduinoServiceWithListeners.getInstance();
    SerialPortDataListener[] listeners = new SerialPortDataListener[2];

    public Thread thread;

    IPrinter printer = new ConsolePrinter();

    /*
    public ArduinoChecker(ActionListener actionListener){
        //actionListener.actionPerformed();
    }
*/

    public void setPort(){
        listeners[0] = new Listener_Data_Available();
        listeners[1] = new Listener_Port_Disconnected();

        thread = new Thread();
        /*
        thread = new Thread(){
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        while (true){
                            System.out.println();

                            arduino.port.removeDataListener();
                            arduino.initListener(new Listener_Port_Disconnected() );
                            //.addDataListener( new Listener_Port_Disconnected());
                            printer.print("111");
                            wait(5);

                            arduino.port.removeDataListener();
                            arduino.initListener(new Listener_Data_Available() );


                            for(SerialPortDataListener listener : listeners){
                                arduino.port.removeDataListener();
                                arduino.port.addDataListener(listener);
                                if(listener instanceof Listener_Port_Disconnected){
                                    if(((Listener_Port_Disconnected) listener).isDisconnected() ) {
                                        thread.interrupt();
                                        throwEventListener();
                                    }
                                }
                                wait(5);
                            }


                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        */

        thread.setDaemon(true);
    }

    public ActionEvent throwEventListener(){
        return new ActionEvent( "Disconnected", 1, "Disconnected" );
    }



}
