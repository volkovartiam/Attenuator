package volkov.artiam.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DELAYS {

    DEFAULT_DELAY(150),
    // PortAndArduinoModel
    AFTER_CONNECT_DELAY(1000),
    // PortDataReader
    DATA_READER_DELAY(500),
    //PortDisconnectChecker
    PORT_CHEKER_DELAY(10),
    SEND_DATA_DELAY(500);

    final int delay;
}
