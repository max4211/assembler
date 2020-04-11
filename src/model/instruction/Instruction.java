package model.instruction;

public abstract class Instruction implements InstructionInterface {

    protected final String[] myString;
    protected final String myOpcode;
    private static final String SPACE = " ";

    public Instruction(String s, String opcode) {
        this.myString = s.split(SPACE);
        this.myOpcode = opcode;
    }
}
