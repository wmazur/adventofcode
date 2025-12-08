package adventofcode.y2025.a07;

import adventofcode.utils.Matrix;

import static adventofcode.utils.Matrix.*;
import static java.util.Optional.ofNullable;

public class RealityCounter {

    //For second part...
    Matrix<Long> alternatives;

    public RealityCounter(Matrix<Character> input) {
        Long[][] alternativesInput = new Long[input.rowNum][input.colNum];
        alternatives = new Matrix<>(alternativesInput);
    }

    public void init(int i, int j) {
        alternatives.set(i,j,1L);
    }

    /**
     * Node (i,j) contains BEAM and was hit by tachyon
     * Now we have two times more realities
     */
    void splitReality(int i, int j) {
        long realitiesCount = alternatives.safeGet(i, j, U);
        //left
        long leftValue = ofNullable(alternatives.safeGet(i,j,L)).orElse(0L) + realitiesCount;
        alternatives.safeSet(i,j,L, leftValue);
        // Right - we are moving left to right, so (assumption) it's always zero
        alternatives.safeSet(i,j,R, realitiesCount);
    }

    /**
     * This field is empty or tachyon and field above is tachyon
     */
    public void continueReality(int i, int j) {
        long realitiesCount = alternatives.safeGet(i, j, U);
        long currentValue = ofNullable(alternatives.safeGet(i,j,X)).orElse(0L);
        alternatives.set(i, j, currentValue + realitiesCount);
    }

    public long sum() {
        long count = 0;
        for (int i = 0; i < alternatives.colNum; i++) {
            count += ofNullable(alternatives.safeGet(alternatives.rowNum - 1, i, X)).orElse(0L);
        }
        return count;
    }
}
