package model.assembler;

import java.util.ArrayList;
import java.util.List;

public class Assembler {

    private static final String myRegisterProperties = "src/data/MIPS/register.properties";
    private static final String myTypeProperties = "src/data/MIPS/type.properties";

    private List<String> myInput;
    private List<String> myOutput;

    public Assembler(List<String> input) {
        this.myInput = input;
        this.myOutput = new ArrayList<>();
    }

}
