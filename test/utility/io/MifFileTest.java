package utility.io;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MifFileTest {

    @Test
    void testSave() {
        Output output = new Output();
        output.add("00000000000000110101000000000000");
        output.add("00000000111000110101000000000000");
        output.add("00000000000000010010010011111111");

        String path = "data/test/mifTest";
        output.write(FileType.MIF, path);
    }

}