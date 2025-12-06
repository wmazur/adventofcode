package adventofcode.y2025.a02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.FileReader.splitOn;
import static org.junit.jupiter.api.Assertions.*;

class Solution02Test extends SolutionUtils{



    @BeforeEach
    public void init(){
        solution = new Solution02();
    }
    @Test
    public void partOneMultitest02(){



        var ranges = Arrays.asList(splitOn(input01));
        var iterator = ranges.iterator();
        verifyPatternsSpotted(iterator.next(), 11, 22);
        verifyPatternsSpotted(iterator.next(), 111, 99 );
        verifyPatternsSpotted(iterator.next(), 999, 1010);
        verifyPatternsSpotted(iterator.next(), 1188511885);
        verifyPatternsSpotted(iterator.next(), 222222);
        verifyPatternsSpotted(iterator.next());
        verifyPatternsSpotted(iterator.next(), 446446);
        verifyPatternsSpotted(iterator.next(), 38593859);
        verifyPatternsSpotted(iterator.next(), 565656);
        verifyPatternsSpotted(iterator.next(), 824824824);
        verifyPatternsSpotted(iterator.next(), 2121212121);
    }

    @Test
    public void test0102() {
        var result = solution.solve(splitOn(input01, ","));
        assertEquals(4174379265L, result);
    }

    @Test
    public void test0202() throws IOException {
        List<String> input = readFile("src/test/java/adventofcode/y2025/a02/input.txt");

        var result = solution.solve(splitOn(input.getFirst(), ","));
        assertEquals(79183223243L, result);
    }
}