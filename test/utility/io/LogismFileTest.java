package utility.io;

import org.junit.jupiter.api.Test;

class LogismFileTest {

    @Test
    void testSave() {
        Output output = new Output();
        output.add("00000000000000110101000000000000");
        output.add("00000000111000110101000000000000");
        output.add("00000000000000010010010011111111");

        String path = "data/test/";
        output.write(FileType.LOGISM, path);
    }
}