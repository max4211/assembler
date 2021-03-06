package utility.io;

public enum FileType {

    MIF("Mif"),
    LOGISM("Logism"),
    TEXT("Text");

    private final String myType;

    private FileType(String type) {
        this.myType = type;
    }

    @Override
    public String toString() {
        return this.myType;
    }

}
