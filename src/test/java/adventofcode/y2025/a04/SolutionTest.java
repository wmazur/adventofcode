package adventofcode.y2025.a04;

import adventofcode.utils.Matrix;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode.y2025.a04.Solution.getAccessibleRollsCount;
import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.Mapper.fromMultilineStringToChars;
import static adventofcode.utils.Mapper.fromStringsToChars;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    String example =
            """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
            """;
    @Test
    public void testSmall() throws InterruptedException {


        Solution s= new Solution();

        Matrix<Character> characterMatrix = fromMultilineStringToChars(example);
        Matrix<Character> solution = s.solve01(characterMatrix);

        String expectedResult =
                """
                ..xx.xx@x.
                x@@.@.@.@@
                @@@@@.x.@@
                @.@@@@..@.
                x@.@@@@.@x
                .@@@@@@@.@
                .@.@.@.@@@
                x.@@@.@@@@
                .@@@@@@@@.
                x.x.@@@.x.
                """;

        Matrix<Character> expectedOutput = fromMultilineStringToChars(expectedResult);
        assertEquals(expectedOutput, solution, expectedOutput.diff(solution));

        assertEquals(13, getAccessibleRollsCount(solution));

    }

    @Test
    public void testPartOne() throws IOException, InterruptedException {
        List<String> input = readFile("src/test/java/adventofcode/y2025/a04/input.txt");
        Matrix<Character> characterMatrix = fromStringsToChars(input.toArray(new String[0]));

        Solution s= new Solution();
        Matrix<Character> solution = s.solve01(characterMatrix);

        assertEquals(13, getAccessibleRollsCount(solution));
    }

    @Test
    public void testSmall02(){
        Solution s= new Solution();

        Matrix<Character> characterMatrix = fromMultilineStringToChars(example);
        long solution = s.solve02(characterMatrix);
        assertEquals(43, solution);
    }

    @Test
    public void testPartTwo() throws IOException {
        Solution s= new Solution();

        List<String> input = readFile("src/test/java/adventofcode/y2025/a04/input.txt");
        Matrix<Character> characterMatrix = fromStringsToChars(input.toArray(new String[0]));

        long solution = s.solve02(characterMatrix);

        assertEquals(9518, solution);
    }
}