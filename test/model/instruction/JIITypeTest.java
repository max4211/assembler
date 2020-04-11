package model.instruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JIITypeTest {

    @Test
    void testExecute() {
        String inst = "jr 5";
        Instruction jrInst = new JIIType(inst, "00100");
        String result = jrInst.execute();
        String expected = "00100001010000000000000000000000";
//        System.out.printf("expected.length() = %d\n", expected.length());
        assertEquals(expected, result);
    }

}