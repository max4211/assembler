import ISA.ISA;
import data.xmlreader.XMLReader;
import model.assembler.Assembler;
import org.xml.sax.SAXException;
import utility.io.FileType;
import utility.io.Input;
import utility.io.Output;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String[] args)  {
        try {
            // CODE WHICH WILL BE USER INPUT PARAMETERS
            String ISAfile = "src/data/MIPS/ece350ISA.xml";
            String inputPath = "data/test/fullALUtest.s";
            String outputPath = "data/test/srcmain";
            File text = new File(inputPath);

            // MODEL CODE TO GET TO OUTPUT
            XMLReader reader = new XMLReader(ISAfile);
            ISA myISA = reader.getISA();
            Assembler myAssembler = new Assembler(myISA);
            Input input = new Input(text);

            // FINAL OUTPUT CONSTRUCTION AND WRITE
            Output output = myAssembler.assemble(input);
            output.write(FileType.LOGISM, outputPath);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Could not assemble file");
            e.printStackTrace();
        }

    }

}
