package model.assembler;

import utility.io.Input;
import utility.io.Output;

import java.util.List;

public interface AssemblerInterface {

    /**
     * Called by main after Assembler has been created
     * @param input file formatted list/string to assemble
     * @return output in curated format (ready to write)
     */
    Output assemble(Input input);

}
