package model.instruction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RTypeTest {

    @Test
    void testExecute() {
        String inst = "add 0 1 2";
        Instruction addInst = new RType(inst);
        String binResult = addInst.execute();
        String binExpect = "00000000000000100010000000000000";
        assertEquals(binResult, binExpect);
    }

}