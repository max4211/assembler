package model.instruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NOPTypeTest {

    @Test
    void execute() {
        String inst = "nop";
        Instruction nop = new NOPType(inst, "00000");
        String result = nop.execute();
        String expected = "00000000000000000000000000000000";
        System.out.printf("result.length(): %d\nexpected.length():%d\n", result.length(), expected.length());
        assertEquals(expected, result);
    }
}