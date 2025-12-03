package adventofcode.y2025.a02;

import java.util.Collection;
import java.util.HashSet;

public class Solution02 extends Solution{
    @Override
    protected Collection<Long> getSillyPatterns(long from, long stop) {
        var patterns = new HashSet<Long>();
        var multiplier = 10;
        var index = 1L;

        while(true){
            var innerBreak = multiplier - 1; //9, 99, 999...

            for( ; index <= innerBreak; index++){
                var toBeChecked = index * multiplier + index;
                if (toBeChecked > stop) { // out of range
                    return patterns;
                }
                do{
                    if(toBeChecked >= from && toBeChecked <= stop) {
                        if(!patterns.add(toBeChecked)){
                            // Example: number 2222 was already added by [2 2 2 2]
                            // While now we are processing [22 22]
                            break;
                        }
                    }
                    toBeChecked = toBeChecked * multiplier + index;
                }while (toBeChecked <= stop); //Within range
            }
            // longer numbers
            multiplier *= 10;
        }
    }
}
