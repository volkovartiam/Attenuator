package volkov.artiam.arduino;

public interface PrintImpl {

    public void sendData(String command);

    public boolean isReady();

}
