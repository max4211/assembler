import model.assembler.Assembler;

import java.util.List;

public class Main {

    private static final String test = "add $1, $2, $3";

    public static void main (String[] args) {
        System.out.println("Hello world!");
        Assembler myAssembler = new Assembler(List.of(test));
    }
}
