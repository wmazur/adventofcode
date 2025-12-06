package adventofcode.utils;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@EqualsAndHashCode
public class Matrix<T> {
    public final int colNum;
    public final int rowNum;

    private final T[][] m;

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

    public T get(int i, int j) {
        return m[i][j];
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
}
