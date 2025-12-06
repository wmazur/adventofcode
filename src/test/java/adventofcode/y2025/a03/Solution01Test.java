package adventofcode.y2025.a03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.FileReader.splitOnDigits;
import static org.junit.jupiter.api.Assertions.*;

class Solution01Test {

    private final Solution01 solution01 = new Solution01(2);
    int numberOfDigits = 2;

    @ParameterizedTest
    @CsvSource({
            "987654321111111,98",
            "811111111111119,89",
            "234234234234278,78",
            "818181911112111, 92",
            "99818181911112111, 99",
    })
    public void testPart(String stringInput, int expectedResult){
        var input = splitOnDigits(stringInput);

        var solver = new SolveOneArray(input, numberOfDigits);
        var result = solver.solve();

        assertEquals(expectedResult, result);
    }


    @Test
    public void testPartSum() {
        List<String> input = List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        );
        var result = solution01.solve(input);
        assertEquals(357, result);
    }

    @Test
    public void test01() throws IOException {
        List<String> input = readFile("src/test/java/adventofcode/y2025/a03/input.txt");
        var result = solution01.solve(input);
        assertEquals(17155, result);
    }
}