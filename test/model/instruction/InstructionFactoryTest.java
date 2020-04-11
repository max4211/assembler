package model.instruction;

import ISA.ISA;
import data.xmlreader.XMLReader;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InstructionFactoryTest {

    @Test
    void testRTypeCreate() throws ParserConfigurationException, SAXException, IOException {
        String file = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(file);
        ISA myISA= reader.getISA();
        InstructionFactory factory = new InstructionFactory(myISA);
        String inst = "add 0 1 21";
        Instruction addInst = factory.createInstruction(inst);
        String expected = "00000000000000110101000000000000";
        assertEquals(expected, addInst.execute());
    }

    @Test
    void testITypeCreate() throws ParserConfigurationException, SAXException, IOException {
        String file = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(file);
        ISA myISA= reader.getISA();
        InstructionFactory factory = new InstructionFactory(myISA);
        String inst = "addi 0 1 21";
        String expected = "00101000000000100000000000010101";
        Instruction addiInst = factory.createInstruction(inst);
        assertEquals(expected, addiInst.execute());
    }

    @Test
    void testJITypeCreate() throws ParserConfigurationException, SAXException, IOException {
        String file = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(file);
        ISA myISA= reader.getISA();
        InstructionFactory factory = new InstructionFactory(myISA);
        String inst = "jal 5";
        String expected = "00011000000000000000000000000101";
        Instruction jalInst = factory.createInstruction(inst);
        assertEquals(expected, jalInst.execute());
    }

    @Test
    void testJIITypeCreate() throws ParserConfigurationException, SAXException, IOException {
        String file = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(file);
        ISA myISA= reader.getISA();
        InstructionFactory factory = new InstructionFactory(myISA);
        String inst = "jr 5";
        String expected = "00100001010000000000000000000000";
        Instruction jrInst = factory.createInstruction(inst);
        assertEquals(expected, jrInst.execute());
    }

}