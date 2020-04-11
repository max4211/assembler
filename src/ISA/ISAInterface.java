package ISA;

import utility.Pair;

public interface ISAInterface {

    /**
     * Get pair of instruction (type and code) for instruction factory
     * @param inst is the instruction to search for
     * @return
     */
    Pair getPair(String inst);

}
