package model.assembler;

import java.util.List;

public interface AssemblerInterface {

    /**
     * Called by main after Assembler has been created
     * @param input file formatted list/string to assemble
     * @return output in native java format
     */
    List<String> assemble(List<String> input);

    List<String> getOutput();
}
