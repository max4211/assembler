package model.instruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JITypeTest {

    @Test
    void testExecute() {
        String inst = "jal 5";
        Instruction jalInst = new JIType(inst, "00011");
        String result = jalInst.execute();
        String expected = "00011000000000000000000000000101";
//        System.out.printf("expected.length() = %d\n", expected.length());
        assertEquals(expected, result);
    }

}