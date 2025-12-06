package adventofcode.y2025.a05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.Mapper.fromMultilineStringToListOfStrings;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {
    String example = """
            3-5
            10-14
            16-20
            12-18
            
            1
            5
            8
            11
            17
            32
            """;

    @Test
    public void exampleTest(){
        List<String> input = fromMultilineStringToListOfStrings(example);

        Solution s = new Solution(input);
        var result = s.solve01();
        assertEquals(3, result, s.describeSolution());
        // Part two

        result = s.solve02();
        assertEquals(14, result, s.describeSolution());
        log.info(s.describeSolution());
    }

    @Test
    public void doesItReadLastLineTest(){
        String str = """
                2-2
                5-10
                
                2
                0
                3
                7
                """;
        List<String> input = fromMultilineStringToListOfStrings(str);
        Solution s = new Solution(input);
        var result = s.solve01();
        assertEquals(2, result, s.describeSolution());
        // Part two

        result = s.solve02();
        assertEquals(7, result, s.describeSolution());

        log.info(s.describeSolution());
    }

    @Test
    public void test01() throws IOException {

        List<String> input = readFile("src/test/java/adventofcode/y2025/a05/input.txt");
        Solution s = new Solution(input);
        var result = s.solve01();

        assertEquals(885, result);

        // Part two

        result = s.solve02();
        assertEquals(348115621205535L, result, s.describeSolution());
    }



}