package data.xmlreader;

import java.util.List;
import java.util.Map;

/**
 * Module that translates XML-defined ISA into Java friendly structures
 */
public interface XMLParseInterface {

    /**
     * Called by main to get instructions from approriate isa file for instruction generation
     * @return Triplet list of all instructions
     */
    List<Triplet> getInstructions();

}
