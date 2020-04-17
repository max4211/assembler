package utility.converter;

public class Converter {

    private static final int ZERO = 0;

    private final String myInputValue;
    private final Base myInputBase;
    private final Base myOutputBase;
    private final int myDigits;

    public Converter(String inputValue, String inputBase, String outputBase, String digits) {
        this.myInputValue = inputValue;
        this.myInputBase = Base.valueOf(inputBase);
        this.myOutputBase = Base.valueOf(outputBase);
        this.myDigits = Integer.parseInt(digits);
    }

    // TODO - refactor into an interface (redo converter interface)
    public String execute() {
        int dec = Integer.parseInt(this.myInputValue, this.myInputBase.getBase());
        String bin = Integer.toString(dec, this.myOutputBase.getBase());
        return signExtend(bin, this.myDigits);
    }

    private String signExtend(String input, int digits) {
        StringBuilder temp = new StringBuilder();
        int pad = digits - input.length();
        for (int i = 0; i < pad; i ++)
            temp.append(ZERO);
        return temp.toString() + input;
    }

}
