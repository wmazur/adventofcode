package adventofcode.y2025.advent01;

import static adventofcode.y2025.utils.FileReader.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void testSimple() throws IOException {

        List<String> input = readFile("src/test/java/adventofcode/y2025/advent01/input01.txt");

        Solution solution = new Solution();
        int result = solution.solvePartOne(input);
        assert result == 3;
    }

    @Test
    public void test() throws IOException {

        List<String> input = readFile("src/test/java/adventofcode/y2025/advent01/input.txt");

        Solution solution = new Solution();
        int result = solution.solvePartOne(input);
        assertEquals(1055, result);
    }

    //Part two
        @Test
    public void testSimple02() throws IOException {

        List<String> input = readFile("src/test/java/adventofcode/y2025/advent01/input01.txt");

        Solution solution = new Solution();
        int result = solution.solvePartTwo(input);
        assertEquals(6, result);
    }

    @Test
    public void test02() throws IOException {

        List<String> input = readFile("src/test/java/adventofcode/y2025/advent01/input.txt");

        Solution solution = new Solution();
        int result = solution.solvePartTwo(input);
        assertEquals(6386, result);
    }

    // Helper tests

    @Test
    public void test03() {

        List<String> input = List.of("R150");

        Solution solution = new Solution();
        int result = solution.solvePartTwo(input);
        assertEquals(2, result);
    }
    

    @Test
    public void test04() {

        List<String> input = List.of("L150");

        Solution solution = new Solution();
        int result = solution.solvePartTwo(input);
        assertEquals(2, result);
    }
    
}
