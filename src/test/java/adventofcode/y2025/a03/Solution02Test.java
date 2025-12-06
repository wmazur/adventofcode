package adventofcode.y2025.a03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.FileReader.splitOnDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02Test {

    private final Solution01 solution01 = new Solution01(12);
    int numberOfDigits = 12;

    @ParameterizedTest
    @CsvSource({
            "987654321111111, 987654321111",
            "811111111111119, 811111111119",
            "234234234234278, 434234234278",
            "818181911112111, 888911112111",
            "998181819111121, 998181819121",
    })
    public void testPart(String stringInput, long expectedResult){
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
        assertEquals(3121910778619L, result);
    }

    @Test
    public void test02() throws IOException {
        List<String> input = readFile("src/test/java/adventofcode/y2025/a03/input.txt");
        var result = solution01.solve(input);
        assertEquals(169685670469164L, result);
    }
}