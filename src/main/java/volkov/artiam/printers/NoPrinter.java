package volkov.artiam.printers;

public class NoPrinter implements IPrinter {
    @Override
    public void print(Object object) {
    }

    @Override
    public void print(Object object, boolean isPrintable) {
        if(isPrintable){
            print(object);
        }
    }
}
