package volkov.artiam.panels.port;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.ActionEvent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class PortTest {

    Port port;

    @BeforeEach
    void setUp() {
        port = new Port();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        //setAllToNulls();
    }

    @Test
    void portConnectedTest() {
        JButton btnConnect = port.getBtnConnect();

        assertFalse( port.getBtnLed().isEnabled() );
        port.actionPerformed( new ActionEvent( btnConnect, 0, "Подключение" ));
        //assertThat(port.getMessage(), equalTo("tryToConnect") );

        port.setConnectedOrDisconnectedView(true);
        port.setSelectedPort("COM8");

        assertTrue( port.getBtnLed().isEnabled() );
        assertFalse( port.getBtnUpdate().isEnabled() );
        assertFalse( port.getComboPortSelection().isEnabled() );
    }


    @Test
    void portIsNotConnectedTest() {
        JButton btnConnect = port.getBtnConnect();

        assertFalse( port.getBtnLed().isEnabled() );
        port.actionPerformed( new ActionEvent( btnConnect, 0, "Подключение" ));
        //assertThat(port.getMessage(), equalTo("tryToConnect") );

        port.setConnectedOrDisconnectedView(false);

        assertFalse( port.getBtnLed().isEnabled() );
        assertTrue( port.getBtnUpdate().isEnabled() );
        assertTrue( port.getComboPortSelection().isEnabled() );
    }

    @Test
    void portIsUpdated() {
        JButton btnUpdate = port.getBtnUpdate();

        port.actionPerformed( new ActionEvent( btnUpdate, 0, "" ));
        //assertThat(port.getMessage(), equalTo("update") );

        String[] newPorts = { "COM9", "COM8", "COM7"};
        port.setPorts(newPorts);

        assertThat(port.getSelectedPort(), equalTo("COM9") );

    }

}