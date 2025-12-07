package adventofcode.y2025.a06;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.Mapper.fromMultilineStringToListOfStrings;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    String example = "123 328  51 64 \n" +
                     " 45 64  387 23 \n" +
                     "  6 98  215 314\n" +
                     "*   +   *   +  ";

    @Test
    public void testExample01(){
        var input = fromMultilineStringToListOfStrings(example);
        Solution solution = new Solution();
        var result = solution.solve01(input);
        assertEquals(4277556, result);
    }
    @Test
    public void test01() throws IOException {
        List<String> input = readFile("src/test/java/adventofcode/y2025/a06/input.txt");

        Solution solution = new Solution();
        var result = solution.solve01(input);
        assertEquals(4583860641327L, result);
    }

    @Test
    public void testExample02(){
        var input = fromMultilineStringToListOfStrings(example);
        Solution solution = new Solution();
        var result = solution.solve02(input);
        assertEquals(3263827, result);
    }
    @Test
    public void test02() throws IOException {
        List<String> input = readFile("src/test/java/adventofcode/y2025/a06/input.txt");

        Solution solution = new Solution();
        var result = solution.solve02(input);
        assertEquals(11602774058280L, result);
    }

}