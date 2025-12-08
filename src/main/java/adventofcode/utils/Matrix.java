package adventofcode.utils;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@Slf4j
@EqualsAndHashCode
public class Matrix<T> {
    public final int colNum;
    public final int rowNum;

    private final T[][] m;

    public final static Pair<Integer, Integer> UL = new ImmutablePair<>(-1, -1);
    public final static Pair<Integer, Integer> U = new ImmutablePair<>(-1, 0);
    public final static Pair<Integer, Integer> UR = new ImmutablePair<>(-1, 1);
    public final static Pair<Integer, Integer> L = new ImmutablePair<>(0, -1);
    public final static Pair<Integer, Integer> X = new ImmutablePair<>(0, 0);
    public final static Pair<Integer, Integer> R = new ImmutablePair<>(0, 1);
    public final static Pair<Integer, Integer> DL = new ImmutablePair<>(1, -1);
    public final static Pair<Integer, Integer> D = new ImmutablePair<>(1, 0);
    public final static Pair<Integer, Integer> DR = new ImmutablePair<>(1, 1);

    public Matrix(T[][] input) {
        if (input.length == 0) {
            this.colNum = 0;
            this.rowNum = 0;
        } else {
            this.colNum = input[0].length;
            this.rowNum = input.length;
        }

        m = input;
    }


    public Collection<T> neighbours(int i, int j){
        Collection<T> response = new ArrayList<>(9);
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if(k == 0 && l == 0){
                    continue;
                } else {
                    var x = i + k;
                    var y = j + l;
                    if(x >= 0 && y >= 0 && x < rowNum && y < colNum){
                        response.add(m[x][y]);
                    }
                }
            }
        }
        return response;
    }

    //Unsafe
    public T get(int i, int j) {
        return m[i][j];
    }


    public void set(int i, int j, T value) {
        m[i][j] = value;
    }

    public String diff(Matrix<T> other) {
        if(rowNum != other.rowNum)
            return "rowNum does not match";
        if(colNum != other.colNum)
            return "colNum does not match";

        StringBuilder output = new StringBuilder("\n");
        for (int i = 0; i < colNum; i++) {
            for (int j = 0; j < rowNum; j++) {
                if(m[i][j].equals(other.get(i,j))){
                    output.append('.');
                } else {
                    output.append(m[i][j]);
                }
            }
            output.append('\n');
        }
        return output.toString();
    }

    public Stream<T[]> stream() {
        return Arrays.stream(m);
    }

    /**
     * Return value or null if Index out of bound
     */
    public T safeGet(int i, int j, Pair<Integer, Integer> direction) {
        int x = i + direction.getLeft();
        int y = j + direction.getRight();
        if(x >=0 && x < rowNum && y >=0 && y < colNum) {
            return m[x][y];
        } else {
            return null;
        }
    }

    public boolean safeSet(int i, int j, Pair<Integer, Integer> direction, T value) {
        int x = i + direction.getLeft();
        int y = j + direction.getRight();
        if(x >=0 && x < rowNum && y >=0 && y < colNum){
            m[x][y] = value;
            return true;
        } else {
            log.debug("{} {} Out of range", x, y);
        }
        return false;
    }

    public String print(){
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                sb.append(m[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
