package adventofcode.y2025.a02;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class SolutionUtils {
    Solution solution;


    String input01 = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
            "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
            "824824821-824824827,2121212118-2121212124";

    void verifySum(String range, long expectedSum) {
        log.info(range);
        var rangeTuple = range.split("-");

        var result = solution.solve(rangeTuple[0], rangeTuple[1]);
        assertEquals(expectedSum, result);

    }

    void verifyPatternsSpotted(String range, long... expectedValues) {
        log.info(range);
        var rangeTuple = range.split("-");

        var result = solution.check(rangeTuple[0], rangeTuple[1]);

        log.info("{} {}", Arrays.toString(expectedValues), result.toString());

        assertEquals(expectedValues.length, result.size());

        HashSet<Long> resultSet = new HashSet<>(result);

        for (long expectedValue : expectedValues) {
            assertTrue(resultSet.contains(expectedValue));
        }
    }
}
