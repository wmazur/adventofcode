package adventofcode.y2025.a04;

import adventofcode.utils.Matrix;

import java.util.Arrays;

public class Solution {

    static char X = 'x';
    char ROLL = '@';

    public Matrix<Character> solve01(Matrix<Character> input) throws InterruptedException {
        boolean somethinChanged = false;
        Character[][] solution = new Character[input.colNum][input.rowNum];
        for (int i = 0; i < input.colNum; i++) {
            for (int j = 0; j < input.rowNum; j++) {
                solution[i][j] = input.get(i, j);
                if (input.get(i, j) == ROLL) {
                    long rollCount = input.neighbours(i, j).stream()
                            .filter(c -> c == ROLL)
                            .count();
                    if (rollCount < 4) {
                        solution[i][j] = X;
                        somethinChanged = true;
                    }
                }
            }
        }
        if(!somethinChanged)
            throw new InterruptedException();
        return new Matrix<>(solution);
    }

    public long solve02(Matrix<Character> input) {
        long initialRollsCount = count(input, ROLL);
        var temp = input;
        try {
            while(true){
                temp = solve01(temp);
            }
        } catch (InterruptedException e) {
            return initialRollsCount - count(temp, ROLL);
        }
    }

    public static long getAccessibleRollsCount(Matrix<Character> m){
        return count(m, X);

    }

    private static long count(Matrix<Character> m, Character character) {
        return m.stream()
                .flatMap(Arrays::stream)
                .filter(c -> c == character)
                .count();
    }
}
