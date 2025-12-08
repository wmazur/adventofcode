package adventofcode.y2025.a07;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static adventofcode.utils.FileReader.readFile;
import static adventofcode.utils.Mapper.*;
import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SolutionTest {

    String example = """
            .......S.......
            ...............
            .......^.......
            ...............
            ......^.^......
            ...............
            .....^.^.^.....
            ...............
            ....^.^...^....
            ...............
            ...^.^...^.^...
            ...............
            ..^...^.....^..
            ...............
            .^.^.^.^.^...^.
            ...............
            """;

    @Test
    public void testExample01(){
        var input = fromMultilineStringToChars(example);
        var s = new Solution(input);
        var result = s.solve();
        log.info(input.print());
        log.info("Manual count: {}",pow(2,22));
        assertEquals(21, result);
        assertEquals(40, s.alternativesCount());
    }

    @Test
    public void test01() throws IOException {
        List<String> source = readFile("src/test/java/adventofcode/y2025/a07/input.txt");
        var input = fromListToMatrix( source);
        var s = new Solution(input);
        var result = s.solve();
        log.info(input.print());
        assertEquals(1628, result);
        assertEquals(27055852018812L, s.alternativesCount());
    }

}