package model.instruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RTypeTest {

    @Test
    void testExecute() {
        String inst = "add 0 1 21";
        Instruction addInst = new RType(inst, "00000");
        String result = addInst.execute();
        String expected = "00000000000000110101000000000000";
//        System.out.printf("expected.length() = %d\n", expected.length());
        assertEquals(expected, result);
    }

    @Test
    void testShift() {
        String inst = "sll 0 1 21";
        Instruction shiftInst = new RType(inst, "00011");
        String result = shiftInst.execute();
        String expected = "00000000000000100000101010001100";
//        System.out.printf("expected.length() = %d\n", expected.length());
        assertEquals(expected, result);
    }



}