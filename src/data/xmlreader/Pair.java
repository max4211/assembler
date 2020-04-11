package data.xmlreader;

/**
 * A simple example used in many tutorials.
 *
 * Replicates the functionality of Map.Entry, but is perhaps simpler to use.
 *
 * @author Robert C. Duvall, Max A. Smith
 */
public class Pair<A, B> {
    // immutable instance variables
    // NOTE: these can be any two types, same or different
    private final A myFirst;
    private final B mySecond;


    /**
     * Create a pair directly from the given values
     */
    public Pair(A first, B second) {
        this.myFirst = first;
        this.mySecond = second;
    }

    // NOTE: provides getters, but not setters

    /**
     * Returns first value in triplet
     */
    public A getFirst() {
        return this.myFirst;
    }

    /**
     * Returns second value in triplet
     */
    public B getSecond() {
        return this.mySecond;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "(" + this.myFirst + ", " + this.mySecond + ")";
    }
}
