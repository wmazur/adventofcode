package adventofcode.utils;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

//maybe for future use
public class OverengineeredPieceOfCrapMatrix<T> {

    public static final int THREE = 3;
    private final int colNum;
    private final int rowNum;
    private final Cell<T>[] m;

    public OverengineeredPieceOfCrapMatrix(T[][] input) {
        if (input.length == 0) {
            this.colNum = 0;
            this.rowNum = 0;
        } else {
            this.colNum = input[0].length;
            this.rowNum = input.length;
        }
        // Internally - 1D array
        m = new Cell[colNum * rowNum];

        for (int i = 0; i < rowNum; i++) {
            if (input[i].length != colNum)
                throw new IllegalArgumentException("Not even number of columns");
            for (int j = 0; j < colNum; j++) {
                m[i * j + j] = new Cell<>(new ImmutablePair<>(i, j), input[i][j]);
            }

        }
    }

    public Optional<Cell<T>> get(Pair<Integer, Integer> p) {
        return get(p.getLeft(), p.getRight());

    }

    public Optional<Cell<T>> get(int i, int j) {
        if (i < 0 || j < 0 || i >= colNum || j >= rowNum)
            return Optional.empty();
        else
            return Optional.of(m[i*j + j]);
    }


    public CellWithNeighbours<T> neighbour8(Cell<T> c) {
        return neighbour8(c.getLeft());
    }

    public CellWithNeighbours<T> neighbour8(Pair<Integer, Integer> p) {
        return neighbour8(p.getLeft(), p.getRight());
    }

    public CellWithNeighbours<T> neighbour8(int i, int j) {
        Optional<T>[][] optionals = new Optional[THREE][];
        for (int k = 0; k < THREE; k++) {
            optionals[k] = new Optional[THREE];
            for (int l = 0; l < THREE; l++) {
                if(k == 1 && l == 1){
                    optionals[k][l] = Optional.empty();
                } else {
                    optionals[k][l] = get(i + k - 1, j + l - 1).map(ImmutablePair::getRight);
                }
            }
        }
        return new CellWithNeighbours<>(optionals);
    }

    public CellWithNeighbours<T> neighbour9(int i, int j) {
        Optional<T>[][] optionals = new Optional[THREE][];
        for (int k = 0; k < THREE; k++) {
            optionals[k] = new Optional[THREE];
            for (int l = 0; l < THREE; l++) {
                optionals[k][l] = get(i + k - 1, j + l - 1).map(ImmutablePair::getRight);
            }
        }
        return new CellWithNeighbours<>(optionals);
    }

    public <R> Stream<R> forEach(Function<Cell<? super T>, ? extends R> mapper) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                R applied = mapper.apply(get(i,j).get());
                result.add(applied);
            }
        }
        return result.stream();
    }

    public Stream<Cell<T>> stream() {
        return Arrays.stream(m);
    }
}
