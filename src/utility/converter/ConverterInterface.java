package utility.converter;

public interface ConverterInterface {

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

    static String intToBinary(String s, int digits) {
        int dec = Integer.parseInt(s, Base.DEC.getBase());
        String bin = Integer.toString(dec, Base.BIN.getBase());
        return signExtend(bin, digits);
    }

    static String binaryToHex(String s, int digits) {
        int dec = Integer.parseInt(s, Base.BIN.getBase());
        String hex = Integer.toString(dec, Base.HEX.getBase());
        return signExtend(hex, digits);
    }

    static String intToHex(String s, int digits) {
        int dec = Integer.parseInt(s, Base.DEC.getBase());
        String hex = Integer.toString(dec, Base.HEX.getBase());
        return signExtend(hex, digits);
    }

    static String signExtend(String input, int digits) {
        StringBuilder temp = new StringBuilder();
        int pad = digits - input.length();
        for (int i = 0; i < pad; i ++) {
            temp.append(ZERO);
        }
        return temp.toString() + input;
    }
}
