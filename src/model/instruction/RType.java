package model.instruction;

import utility.Converter;

public class RType extends Instruction {

    private static final String OPCODE = "00000";
    private static final int $rd = 1;
    private static final int $rs = 2;
    private static final int $rt = 3;
    private static final int aluop = 1;

    private static final String ZEROES = "00";
    private static final String EMPTY = "00000";


    public RType(String s, String opcode) {
        super(s, opcode);
    }

    // TODO - add in shamt execution
    // TODO - refactor all instructions to enums
    @Override
    public String execute() {
        StringBuilder sb = new StringBuilder();
        sb.append(OPCODE);
        sb.append(convertIndex($rd));
        sb.append(convertIndex($rs));
        sb.append(convertIndex($rt));
        sb.append(EMPTY);
        sb.append(this.myOpcode);
        sb.append(ZEROES);
        return sb.toString();
    }

    private String convertIndex(int index) {
        return Converter.intToBinary(this.myString[index]);
    }
}
