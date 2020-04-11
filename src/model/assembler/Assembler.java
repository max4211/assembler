package model.assembler;

import ISA.ISA;
import model.instruction.Instruction;
import model.instruction.InstructionFactory;

import java.util.ArrayList;
import java.util.List;

public class Assembler {

    private final ISA myISA;
    private final InstructionFactory myFactory;

    private final List<String> myInput;
    private List<String> myOutput;

    public Assembler(List<String> input, ISA isa) {
        this.myInput = input;
        this.myISA = isa;
        this.myFactory = new InstructionFactory(this.myISA);
        this.myOutput = new ArrayList<>();
    }

}
