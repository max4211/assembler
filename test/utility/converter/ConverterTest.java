package utility.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void testBinToHex() {
        String inputValue = "10101";
        String inputBase = "BIN";
        String outputBase = "HEX";
        String digits = "5";
        Converter c = new Converter(inputValue, inputBase, outputBase, digits);
        String result = c.execute();
        String expected = "00015";
        assertEquals(expected, result);
    }

    @Test
    void testBinToDec() {
        String inputValue = "10101";
        String inputBase = "BIN";
        String outputBase = "DEC";
        String digits = "5";
        Converter c = new Converter(inputValue, inputBase, outputBase, digits);
        String result = c.execute();
        String expected = "00021";
        assertEquals(expected, result);
    }

    @Test
    void testHexToBin() {
        String inputValue = "1ab";
        String inputBase = "HEX";
        String outputBase = "BIN";
        String digits = "12";
        Converter c = new Converter(inputValue, inputBase, outputBase, digits);
        String result = c.execute();
        String expected = "000110101011";
        assertEquals(expected, result);
    }

    @Test
    void testSmallBase() {
        String inputValue = "1ab";
        String inputBase = "HEX";
        String outputBase = "BIN";
        String digits = "4";
        Converter c = new Converter(inputValue, inputBase, outputBase, digits);
        String result = c.execute();
        String expected = "110101011";
        assertEquals(expected, result);
    }



}