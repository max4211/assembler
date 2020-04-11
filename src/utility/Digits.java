package utility;

public enum Digits {

    REGISTER(5),
    N(17),
    T(27);


    private final int myDigits;

    private Digits(int digits) {
        this.myDigits = digits;
    }

    public int getDigits() {
        return this.myDigits;
    }

}
