package utility;

public enum Digits {

    REGISTER(5),
    N(16),
    T(26);


    private final int myDigits;

    private Digits(int digits) {
        this.myDigits = digits;
    }

    public int getDigits() {
        return this.myDigits;
    }

}
