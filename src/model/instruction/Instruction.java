package model.instruction;

public abstract class Instruction implements InstructionInterface {

    protected final String[] myString;
    private static final String SPACE = " ";

    public Instruction(String s) {
        this.myString = s.split(SPACE);
    }
}
