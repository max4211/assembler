import ISA.ISA;
import data.xmlreader.XMLReader;
import model.assembler.Assembler;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import utility.io.FileType;
import utility.io.Input;
import utility.io.Output;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() throws ParserConfigurationException, SAXException, IOException {
        String ISAfile = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(ISAfile);
        ISA myISA = reader.getISA();
        Assembler myAssembler = new Assembler(myISA);
        List<String> text = new ArrayList<>(List.of(
                "add $t9, $t2, $t1 #Hello world",
                "sub $a0, $a1, $a2 #Testing comments",
                "#This is a comment",
                "\n #Please delete me",
                "bne $ra, $gp, $fp #Please delete me too"));
        Input input = new Input(text);
        Output output = myAssembler.assemble(input);
        String path = "data/test/main";
        output.write(FileType.LOGISM, path);
    }

    @Test
    void testMainFile() throws ParserConfigurationException, SAXException, IOException {
        String ISAfile = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(ISAfile);
        ISA myISA = reader.getISA();
        Assembler myAssembler = new Assembler(myISA);
        File text = new File("data/test/fullALUtest.s");
        Input input = new Input(text);
        Output output = myAssembler.assemble(input);
        String path = "data/test/fullALUtest";
        output.write(FileType.LOGISM, path);
    }
}