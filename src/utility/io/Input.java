package utility.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private List<String> myInput;

    public Input(List<String> input) {
        this.myInput = input;
    }

    // TODO - implement input construction from a file
    public Input(File file) {
        this.myInput = new ArrayList<>();
    }

}
