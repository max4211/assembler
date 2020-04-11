package utility.converter;

public interface Converter {

    static final String ZERO = "0";

    static String intToBinary(String s, Digits digits) {
        int dec = Integer.parseInt(s, Base.DEC.getBase());
        String bin = Integer.toString(dec, Base.BIN.getBase());
        return signExtend(bin, digits.getDigits());
    }

    static String binaryToHex(String s, Digits digits) {
        int dec = Integer.parseInt(s, Base.BIN.getBase());
        String hex = Integer.toString(dec, Base.HEX.getBase());
        return signExtend(hex, digits.getDigits());
    }

    private static String signExtend(String input, int digits) {
        StringBuilder temp = new StringBuilder();
        int pad = digits - input.length();
        for (int i = 0; i < pad; i ++) {
            temp.append(ZERO);
        }
        return temp.toString() + input;
    }
}
