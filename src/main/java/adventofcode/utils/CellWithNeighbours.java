package adventofcode.utils;

import java.util.Optional;

public class CellWithNeighbours<T> extends OverengineeredPieceOfCrapMatrix<Optional<T>> {
    public CellWithNeighbours(Optional<T>[][] input) {
        super(input);
    }

    public T value() {
        return get(1,1).get().value().get();
    }
}
