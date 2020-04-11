package utility.io;

public enum FileType {

    MIF("mif"),
    LGSIM("lgsim");

    private final String myType;

    private FileType(String type) {
        this.myType = type;
    }

    @Override
    public String toString() {
        return this.myType;
    }

}
