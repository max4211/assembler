package model.instruction;

import utility.Converter;

public class RType extends Instruction {

    private static final String OPCODE = "00000";

    private static final String ADD = "00000";
    private static final String SUB = "00001";
    private static final String AND = "00010";
    private static final String OR = "00011";
    private static final String SLL = "00100";
    private static final String SRA = "00101";

    private static final int $rd = 1;
    private static final int $rs = 2;
    private static final int $rt = 3;
    private static final int aluop = 1;

    private static final String ZEROES = "00";
    private static final String EMPTY = "00000";


    public RType(String s) {
        super(s);
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
        sb.append(parseALUop());
        sb.append(ZEROES);
        return sb.toString();
    }

    private String parseALUop() {
        String myALUop = this.myString[aluop];
        switch(myALUop) {
//            case Operation.ADD.getType():
//                return Operation.ADD.getBinary();
//                break;
            default:
                return EMPTY;
        }
    }

    private String convertIndex(int index) {
        return Converter.intToBinary(this.myString[index]);
    }
}
