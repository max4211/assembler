package data.xmlreader;

public class Triplet {
    // immutable instance variables
    // NOTE: these can be any two types, same or different
    private final String myName;
    private final String myType;
    private final String myCode;


    /**
     * Create a triplet directly from the given values
     */
    public Triplet(String name, String type, String code) {
        this.myName = name;
        this.myType = type;
        this.myCode=  code;
    }

    // NOTE: provides getters, but not setters

    public String getName() {
        return this.myName;
    }

    public String getType() {
        return this.myType;
    }

    public String getCode() {
        return this.myCode;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "(" + this.myName + ", " + this.myType + ", " + this.myCode + ")";
    }
}
