package model.instruction;

import ISA.ISA;
import exceptions.ReflectionException;
import utility.Pair;

import java.lang.reflect.Constructor;

public class InstructionFactory implements FactoryInterface {

    private static final String INSTRUCTION_PATH = "src/model/instruction/";
    private static final String SPACE = " ";
    private static final int ZERO = 0;
    private final ISA myISA;

    public InstructionFactory(ISA isa) {
        this.myISA = isa;
    }

    @Override
    public Instruction createInstruction(String input) {
        try {
            String inst = input.split(SPACE)[ZERO];
            Pair pair = this.myISA.getPair(inst);
            Class clazz = Class.forName(createInstructionPath(input));
            Constructor ctor = clazz.getConstructor(String.class, String.class);
            return (Instruction) ctor.newInstance(inst, pair.getCode());
        } catch (Exception e) {
            throw new ReflectionException(e);
        }
    }

    private String createInstructionPath(String instruction) {
        return String.format("%s.%s", INSTRUCTION_PATH, instruction);
    }
}
