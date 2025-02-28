package volkov.artiam.adds;

import volkov.artiam.datas.ADDS;
import volkov.artiam.datas.DELAYS;

import java.util.EventListener;

public class ThreadExample {

    static  Thread thread;

    public static void main(String[] args) {

        thread = new Thread(){
            @Override
            public void run() {
                synchronized (this) {
                    //ADDS.waitMilliseconds(DELAYS.PORT_CHEKER_DELAY.getDelay());
                    try {
                        while (true){
                            wait(1000);
                            System.out.println("THREAD");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        ADDS.waitMilliseconds(5000);
        System.out.println("MAIN");
    }



    /*
    public static void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    public static void stopThread(){
        try {
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
}
