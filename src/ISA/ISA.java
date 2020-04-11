package ISA;

import utility.Pair;
import utility.Triplet;

import java.util.List;

public class ISA implements ISAInterface {

    private final List<Triplet> myISA;

    public ISA (List<Triplet> list) {
        this.myISA = list;
    }

    @Override
    public Pair getPair(String inst) {
        for (Triplet t: this.myISA) {
            if (t.getName().equals(inst)) {
                return new Pair(t.getType(), t.getCode());
            }
        }
        return null;
    }
}
