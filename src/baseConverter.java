public class baseConverter {

    private static void convertHex(String s) {
        int dec = Integer.parseInt(s, 16);
        String bin = Integer.toString(dec, 2);
        System.out.printf("HEX: %s --> DEC: %d ---> BIN: %s \n", s, dec, bin);
    }

    private static void convert() {
        String myHex = "55555555";
        convertHex(myHex);
    }

    public static void main (String[] args) {
        convert();
    }
}
