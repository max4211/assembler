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
            String ISAfile = "src/data/MIPS/ece350ISA.xml";
            XMLReader reader = new XMLReader(ISAfile);
            ISA myISA = reader.getISA();
            Assembler myAssembler = new Assembler(myISA);
            String filePath = "data/test/fullALUtest.s";
            File text = new File(filePath);
            Input input = new Input(text);
            Output output = myAssembler.assemble(input);
            String path = "data/test/srcmain";
            output.write(FileType.LOGISM, path);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Could not assemble file");
            e.printStackTrace();
        }

    }

}
