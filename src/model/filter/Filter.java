package model.filter;

import utility.io.Input;

import java.util.ArrayList;
import java.util.List;

public class Filter implements FilterInterface {

    private final Input myInput;

    public Filter(Input input) {
        this.myInput = input;
    }

    @Override
    public Input filter() {
        List<String> output = new ArrayList<>();
        for (String s: this.myInput.getList()) {
            s = filterComments(s);
            s = filterWhitespace(s);
            s = filterCommas(s);
            s = filterRegisters(s);
            s = filterImmediate(s);
            output.add(s);
        }
        return new Input(output);
    }

    private String filterWhitespace(String input) {
        return input;
    }

    private String filterComments(String input) {
        return input;
    }

    private String filterRegisters(String input) {
        return input;
    }

    private String filterCommas(String input) {
        return input;
    }

    private String filterImmediate(String input) {
        return input;
    }

}
