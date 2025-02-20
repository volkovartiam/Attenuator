package volkov.artiam.printers;

public class ConsolePrinter implements IPrinter {

    @Override
    public void print(Object object) {
        System.out.println(object);
    }
}
