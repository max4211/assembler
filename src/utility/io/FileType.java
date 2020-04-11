package utility.io;

public enum FileType {

    MIF("Mif"),
    LGSIM("Lgsim"),
    TXT("Txt");

    private final String myType;

    private FileType(String type) {
        this.myType = type;
    }

    @Override
    public String toString() {
        return this.myType;
    }

}
