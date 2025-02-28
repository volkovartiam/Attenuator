package volkov.artiam.datas;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DELAYS {

    DEFAULT_DELAY(15),

    AFTER_CONNECT_DELAY(900),

    DATA_READER_DELAY(500),

    PORT_CHEKER_DELAY(10),

    SEND_DATA_DELAY(500);

    final int delay;
}
