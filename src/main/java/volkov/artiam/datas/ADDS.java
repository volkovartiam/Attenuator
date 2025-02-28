package volkov.artiam.datas;

import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class ADDS {

    public static void waitMilliseconds(int milSecondsToSleep){
        if(milSecondsToSleep < 0){
              milSecondsToSleep = 1000;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(milSecondsToSleep);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitMilliseconds(){
        waitMilliseconds(2500);
    }


    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS -> ");
        Date now = new Date();
        return sdfDate.format(now);
    }




}