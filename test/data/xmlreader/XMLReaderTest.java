package data.xmlreader;

import ISA.ISA;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import utility.Triplet;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLReaderTest {

    @Test
    void testXMLRead() throws ParserConfigurationException, SAXException, IOException {
        String file = "src/data/MIPS/ece350ISA.xml";
        XMLReader reader = new XMLReader(file);
        ISA myISA= reader.getISA();
        Triplet addTriplet = new Triplet("add", "R", "00000");
        Triplet addiTriplet = new Triplet("addi", "I", "00101");
        assertEquals(myISA.get(0).toString(), addTriplet.toString());
        assertEquals(myISA.get(1).toString(), addiTriplet.toString());
    }

}