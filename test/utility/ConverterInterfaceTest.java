package utility;

import org.junit.jupiter.api.Test;
import utility.converter.ConverterInterface;
import utility.converter.Digits;

import static org.junit.jupiter.api.Assertions.*;

class ConverterInterfaceTest {

    @Test
    void testIntToBinary() {
        String s = "5";
        Digits digits = Digits.REGISTER;
        String output = ConverterInterface.intToBinary(s, digits);
        String expected = "00101";
        assertEquals(expected, output);
    }

}