package volkov.artiam.arduino;

import com.fazecast.jSerialComm.SerialPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import volkov.artiam.arduino.exceptions.NoPortsWithThatNameException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ArduinoTest {

    Arduino arduino; // = Arduino.getInstance();

    @BeforeEach
    void setUp() {
        setAllToNulls();
    }

    @AfterEach
    void tearDown() {
        setAllToNulls();
    }

    private void setAllToNulls(){
        arduino.setPorts(null);
    }

//testing method getAvailblePortsNames()

    @Test
    void getAvailblePortsNamesWithPortsByDefault() {
        String[] portNames = arduino.getAvailblePortsNames();
        assertThat(portNames[0], equalTo("") );
        //assertThat(arduino.getMessage(), equalTo("Нет доступных COM-портов" ) );
    }

    @Test
    void getAvailblePortsNamesWithOnePort() {
        SerialPort port1 = Mockito.mock(SerialPort.class);
        Mockito.when(port1.getSystemPortName()).thenReturn("COM5");

        SerialPort[] sPorts = {port1};
        arduino.setPorts(sPorts);

        String[] portNames = arduino.getAvailblePortsNames();
        assertThat(portNames[0], equalTo("COM5") );
    }

    @Test
    void getPortsNamesWithManyPorts() {
        SerialPort port1 = Mockito.mock(SerialPort.class);
        Mockito.when(port1.getSystemPortName()).thenReturn("COM5");

        SerialPort port2 = Mockito.mock(SerialPort.class);
        Mockito.when(port2.getSystemPortName()).thenReturn("COM6");

        SerialPort[] sPorts = {port1, port2};
        arduino.setPorts(sPorts);

        String[] portNames = arduino.getAvailblePortsNames();
        assertThat(portNames[0], equalTo("COM5") );
        assertThat(portNames[1], equalTo("COM6") );
    }


//testing method setPortByName()

    @Test
    void setPortByNameWhenPortIsNull() throws NoPortsWithThatNameException {
        arduino.setPortByName("COM33");
        //assertThat(arduino.getMessage(), equalTo("Портов с таким именем нет") );
    }

    @Test
    void setPortByNoExistingNameCOM() throws NoPortsWithThatNameException  {
        arduino.setPortByName("COM");
        //assertThat(arduino.getMessage(), equalTo("Портов с таким именем нет") );
    }

    @Test
    void setPortByNoExistingNameSpace() throws NoPortsWithThatNameException  {
        arduino.setPortByName("");
        //assertThat(arduino.getMessage(), equalTo("Портов с таким именем нет") );
    }


    @Test
    void setPortByNameThatNotExistInArray() throws NoPortsWithThatNameException {
        SerialPort port1 = Mockito.mock(SerialPort.class);
        Mockito.when(port1.getSystemPortName()).thenReturn("COM5");

        SerialPort port2 = Mockito.mock(SerialPort.class);
        Mockito.when(port2.getSystemPortName()).thenReturn("COM6");

        SerialPort[] sPorts = {port1, port2};
        arduino.setPorts(sPorts);
        arduino.getAvailblePortsNames();

        arduino.setPortByName("COM");
        //assertThat(arduino.getMessage(), equalTo("Портов с таким именем нет") );
    }

    @Test
    void setPortByNameThatExistInArray() throws NoPortsWithThatNameException {
        SerialPort port1 = Mockito.mock(SerialPort.class);
        Mockito.when(port1.getSystemPortName()).thenReturn("COM5");

        SerialPort port2 = Mockito.mock(SerialPort.class);
        Mockito.when(port2.getSystemPortName()).thenReturn("COM6");

        SerialPort[] sPorts = {port1, port2};
        arduino.setPorts(sPorts);
        arduino.getAvailblePortsNames();

        arduino.setPortByName("COM5");
        //assertThat(arduino.getMessage(), equalTo("") );
    }

}