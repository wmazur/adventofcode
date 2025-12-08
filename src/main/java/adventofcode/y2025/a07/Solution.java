package adventofcode.y2025.a07;

import adventofcode.utils.Matrix;
import lombok.extern.slf4j.Slf4j;

import static adventofcode.utils.Matrix.*;

@Slf4j
public class Solution {
    public static final Character TACHYON = '|';
    public static final Character EMPTY = '.';
    public final Character START = 'S';
    public final Character BEAM = '^';
    private final Matrix<Character> input;
    private final RealityCounter alternatives;


    public Solution(Matrix<Character> input) {
        this.input = input;
        alternatives = new RealityCounter(input);
    }

    public int solve(){
        int splitsNumber = 0;
        int startLocation = getStartLocation();
        input.set(0, startLocation, TACHYON);
        alternatives.init(0, startLocation);

        for (int i = 1; i < input.rowNum; i++) {
            for (int j = 0; j < input.colNum; j++) {
                Character currentCell = input.get(i, j);
                if(currentCell == BEAM && input.get(i-1,j) == TACHYON){
                    alternatives.splitReality(i,j);
                    boolean splitDone = false;
                    if(input.safeGet(i,j,L) == EMPTY || (input.safeGet(i,j,L) == TACHYON)){
                        if(input.safeSet(i,j,L, TACHYON)){
                            splitDone = true;
                        }

                    }
                    if(input.safeGet(i,j,R) == EMPTY || input.safeGet(i,j,R) == TACHYON) {
                        if(input.safeSet(i, j, R, TACHYON)){
                            splitDone = true;
                        }
                    }
                    if(splitDone){
                        splitsNumber++;
                    }
                }
            }
            for (int j = 0; j < input.colNum; j++) {
                Character currentCell = input.get(i, j);
                if(currentCell == EMPTY || currentCell == TACHYON){
                    if(input.safeGet(i,j,U) == TACHYON){
                        input.safeSet(i,j,X, TACHYON);
                        alternatives.continueReality(i,j);
                    }
                }
            }
        }
        log.info("Alternatives: {}", alternatives.sum());
        return splitsNumber;
    }

    public Long alternativesCount(){
        return alternatives.sum();
    }


    private int getStartLocation() {
        for (int i = 0; i < input.colNum; i++) {
            if(input.get(0, i) == START)
                return i;
        }
        throw new IllegalArgumentException("Start not found");
    }
}
