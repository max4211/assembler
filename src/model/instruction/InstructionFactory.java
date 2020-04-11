package model.instruction;

import data.xmlreader.Triplet;
import exceptions.ReflectionException;

import java.lang.reflect.Constructor;
import java.util.List;

public class InstructionFactory {

    private static final String INSTRUCTION_PATH = "src/model/instruction/";
    private final List<Triplet> myISA;

    public InstructionFactory(List<Triplet> ISA) {
        this.myISA = ISA;
    }

    public Instruction createInstruction(String instruction) {
        try {
            Class clazz = Class.forName(createInstructionPath(instruction));
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
