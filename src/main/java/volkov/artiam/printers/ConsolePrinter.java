package volkov.artiam.printers;

import java.io.IOException;

public class ConsolePrinter implements IPrinter {

    @Override
    public void print(Object object) {
        System.out.println(object);
    }
}
