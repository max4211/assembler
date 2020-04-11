package utility.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Input implements Iterable{

    private List<String> myInput;

    public Input(String s) {
        this.myInput = new ArrayList<>(List.of(s));
    }

    public Input(List<String> input) {
        this.myInput = input;
    }

    // TODO - implement input construction from a file
    public Input(File file) {
        this.myInput = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return this.myInput.iterator();
    }
}
