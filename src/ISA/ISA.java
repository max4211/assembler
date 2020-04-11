package ISA;

import utility.Triplet;

import java.util.List;

public class ISA implements ISAInterface {

    private final List<Triplet> myISA;

    public ISA (List<Triplet> list) {
        this.myISA = list;
    }
}
