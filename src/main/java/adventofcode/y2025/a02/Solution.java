package adventofcode.y2025.a02;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.Math.pow;

@Slf4j
public class Solution {

    public Solution() {
    }

    public long solve(String[] input){
        return Arrays.stream(input)
                .map(string -> string.split("-"))
                .map(range -> solve(range[0], range[1]))
                .mapToLong(l -> l)
                .sum();
    }

    public long solve(String from, String to){
        return getSillyPatternsSum(Long.parseLong(from), Long.parseLong(to));
    }

    public List<Long> check(String from, String to){

        return new ArrayList<>(getSillyPatterns(Long.parseLong(from), Long.parseLong(to)));
    }

    private long getSillyPatternsSum(long from, long stop) {
        var sillyPatterns = getSillyPatterns(from, stop);
        return sillyPatterns.stream().mapToLong(Long::longValue).sum();
    }

    protected Collection<Long> getSillyPatterns(long from, long stop) {
        var patterns = new ArrayList<Long>();
        var index = halveNumber(from);
        var multiplier = getMultiplier(index);

        while(true){
            var innerBreak = multiplier - 1; //9, 99, 999...

            for( ; index <= innerBreak; index++){
                var toBeChecked = index * multiplier + index;
                if(toBeChecked < from){
                    continue;
                }
                if(toBeChecked <= stop){ //Within range
                    patterns.add(toBeChecked);
                } else { // out of range
                    return patterns;
                }
            }
            // longer numbers
            multiplier *= 10;
        }
    }

    long getMultiplier(long number) {
        return (long) pow(10, Long.toString(number).length());
    }

    private long halveNumber(Long from) {
        String fromAsString = Long.toString(from);
        var length = fromAsString.length();
        long retVal;
        try {
            retVal = Long.parseLong(fromAsString.substring(0, Math.max(1, length/2)));
        } catch (NumberFormatException e) {
            log.error("Can't halve {}", from);
            throw new RuntimeException(e);
        }
        if(length % 2 == 1)
            retVal = (long)pow(10, (length >> 1));  // 9->10, 999->1000
        return retVal;
    }
}
