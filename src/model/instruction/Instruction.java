package model.instruction;

import utility.converter.ConverterInterface;
import utility.converter.Digits;

public abstract class Instruction implements InstructionInterface {

    protected final String[] myString;
    protected final String myOpcode;

    private static final String SPACE = " ";
    protected static final int $rd = 1;
    protected static final int $rs = 2;
    protected static final int $rt = 3;

    protected static final String ZEROES = "00";
    protected static final String EMPTY = "00000";

    public Instruction(String s, String opcode) {
        this.myString = s.split("\\s+");
        this.myOpcode = opcode;
    }

    public Instruction(String[] s, String opcode) {
        this.myString = s;
        this.myOpcode = opcode;
    }

    protected String convertIndex(int index, Digits digits) {
        return ConverterInterface.intToBinary(this.myString[index], digits);
    }
}
