package model.assembler;

import ISA.ISA;
import data.xmlreader.XMLReader;
import model.instruction.Instruction;
import model.instruction.RType;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import utility.io.Input;
import utility.io.Output;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AssemblerTest {

    @Test
    void testAssemble() throws ParserConfigurationException, SAXException, IOException {
        String file = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(file);
        ISA myISA= reader.getISA();
        Assembler myAssembler = new Assembler(myISA);
        String text = "add 0 1 21";
        Input input = new Input(text);
        Output output = myAssembler.assemble(input);
        String result = output.consoleOut();
        String expected = "00000000000000110101000000000000\n";
        assertEquals(expected, result);
    }

}