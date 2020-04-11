package model.instruction;

public abstract class Instruction implements InstructionInterface {

    protected final String myString;

    public Instruction(String s) {
        this.myString = s;
    }
}
