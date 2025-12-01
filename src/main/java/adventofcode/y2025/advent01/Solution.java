package adventofcode.y2025.advent01;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution {

    String regex = "([LR])(\\d+)";
    Pattern pattern = Pattern.compile(regex);

    public int solvePartOne(List<String> input) {
        int position = 50;

        List<Integer> elements = decode(input);

        int zeros = 0;
        for (int move : elements) {
            position += move;
            while (position < 0) {
                position += 100;
            }
            while (position >= 100) {
                position -= 100;
            }
            if (position == 0) {
                zeros++;
            }
        }
        return zeros;
    }

    public int solvePartTwo(List<String> input) {
        int position = 50;

        List<Integer> elements = decode(input);

        int zeros = 0;
        for (int move : elements) {

            // Special case: we are on zero (already marked) and we are going to move left
            if (position == 0 && move < 0) {
                zeros--;
            }

            position += move;

            while (position < 0) {
                position += 100;
                zeros++;

            }

            while (position >= 100) {
                position -= 100;
                zeros++;
            }

            // Special case we started from position 1:99 and moved left
            // L99+ is covered in "main" while
            if (position == 0 && move < 0) {
                zeros++;
            }

        }
        return zeros;
    }

    private List<Integer> decode(List<String> input) {
        return input.stream()
                .map(line -> {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        String direction = matcher.group(1);
                        int distance = Integer.parseInt(matcher.group(2));
                        return switch (direction) {
                            case "L" -> -1 * distance;
                            case "R" -> distance;
                            default -> throw new IllegalArgumentException("Invalid direction: " + direction);
                        };
                    } else {
                        throw new IllegalArgumentException("Invalid command: " + line);
                    }
                })
                .collect(Collectors.toList());
    }

}
