package utility;

public interface Converter {

    static String intToBinary(String s) {
        int dec = Integer.parseInt(s, Base.DEC.getBase());
        String bin = Integer.toString(dec, Base.BIN.getBase());
        return bin;
    }
}
