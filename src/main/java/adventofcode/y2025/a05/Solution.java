package adventofcode.y2025.a05;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Iterator;
import java.util.List;

@Slf4j
public class Solution {
    private final List<String> input;
    private final Ranges ranges = new Ranges();

    public Solution(List<String> input) {
        this.input = input;
    }

    public long solve01(){
        Iterator<String> iterator = input.iterator();
        var line = iterator.next();
        do{
            addToRanges(line);
            line = iterator.next();
        }while ( !line.isEmpty());

        mergeRanges();

        long freshItemsCount = 0;
        do{
            line = iterator.next();
            if(findFresh(line)) {
                freshItemsCount++;
            }
        }while (iterator.hasNext());
//        log.info(line);
        return freshItemsCount;
    }

    public long solve02(){
        return ranges.countIds();
    }

    private void mergeRanges() {
        ranges.mergeRanges();
    }


    private boolean findFresh(String line) {
        long number = Long.parseLong(line);
        return ranges.find(number);
    }

    private void addToRanges(String line) {
        var range = line.split("-");
        ranges.add(new ImmutablePair<>(Long.parseLong(range[0]), Long.parseLong(range[1])));
    }

    public String describeSolution() {
        return ranges.toString();
    }
}
