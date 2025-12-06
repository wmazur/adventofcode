package adventofcode.y2025.a02;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.FileReader.splitOn;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest extends SolutionUtils {

    @BeforeEach
    public void init() {
        solution = new Solution();
    }

    @Test
    public void partOneMultitest() {

        var ranges = Arrays.asList(splitOn(input01));
        var iterator = ranges.iterator();
        verifyPatternsSpotted(iterator.next(), 11, 22);
        verifyPatternsSpotted(iterator.next(), 99);
        verifyPatternsSpotted(iterator.next(), 1010);
        verifyPatternsSpotted(iterator.next(), 1188511885);
        verifyPatternsSpotted(iterator.next(), 222222);
        verifyPatternsSpotted(iterator.next());
        verifyPatternsSpotted(iterator.next(), 446446);
        verifyPatternsSpotted(iterator.next(), 38593859);
        //The rest of the ranges contain no invalid IDs.
        while (iterator.hasNext())
            verifyPatternsSpotted(iterator.next());

    }

    @Test
    public void partOneMultitestSum() {

        var ranges = Arrays.asList(splitOn(input01));
        var iterator = ranges.iterator();
        verifySum(iterator.next(), 33);
        verifySum(iterator.next(), 99);
        verifySum(iterator.next(), 1010);
        verifySum(iterator.next(), 1188511885);
        verifySum(iterator.next(), 222222);
        verifySum(iterator.next(), 0);
        verifySum(iterator.next(), 446446);
        verifySum(iterator.next(), 38593859);
        //The rest of the ranges contain no invalid IDs.
        while (iterator.hasNext())
            verifySum(iterator.next(), 0);

    }


    @Test
    public void test01() {
        var result = solution.solve(splitOn(input01, ","));
        assertEquals(1227775554L, result);
    }

    @Test
    public void test02() throws IOException {
        List<String> input = readFile("src/test/java/adventofcode/y2025/a02/input.txt");

        var result = solution.solve(splitOn(input.getFirst(), ","));
        assertEquals(56660955519L, result);
    }



}