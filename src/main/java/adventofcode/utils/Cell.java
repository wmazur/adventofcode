package adventofcode.utils;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Cell<T> extends ImmutablePair<Pair<Integer, Integer>, T> {

    public Cell(Pair<Integer, Integer> location, T value) {
        super(location, value);
    }

    public T value() {
        return getRight();
    }
}
