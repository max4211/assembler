package model.instruction;

import ISA.ISA;
import exceptions.ReflectionException;

import java.lang.reflect.Constructor;

public class InstructionFactory implements FactoryInterface {

    private static final String INSTRUCTION_PATH = "src/model/instruction/";
    private static final String SPACE = " ";
    private final ISA myISA;

    public InstructionFactory(ISA isa) {
        this.myISA = isa;
    }

    @Override
    public Instruction createInstruction(String input) {
        try {
            String[] splitInput = input.split(SPACE);
            Class clazz = Class.forName(createInstructionPath(input));
            Constructor ctor = clazz.getConstructor();
            return (Instruction) ctor.newInstance();
        } catch (Exception e) {
            throw new ReflectionException(e);
        }
    }

    private String createInstructionPath(String instruction) {
        return String.format("%s.%s", INSTRUCTION_PATH, instruction);
    }
}
