package model.instruction;

public interface InstructionInterface {

    /**
     * Execute instruction after it has been created
     * @return the executed instruction (binary formatted code)
     */
    String execute();
}
