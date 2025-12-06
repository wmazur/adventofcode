package adventofcode.y2025.a05;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

@Slf4j
public class Ranges {




    private static class Range extends ImmutablePair<Long, Long>{
        public Range(Long left, Long right) {
            super(left, right);
        }
        public Range(Pair<Long, Long> pair) {
            super(pair.getLeft(), pair.getRight());
            if(left > right)
                throw new RuntimeException();
        }
    }

    Set<Range> ranges = new TreeSet<>();

    List<Long> found = new ArrayList<>();
    List<Long> notFound = new ArrayList<>();

    public void add(Pair<Long, Long> newRange){
        var temp = new Range(newRange);
        ranges.add(temp);
    }

    public boolean find(long number) {
        for(Range range: ranges){
            if(range.left <= number && number <= range.right) {
                found.add(number);
                return true;
            }
            //Sorted set
            if(range.left > number)
                return false;
        }
//        log.info(Long.toString(number));
        notFound.add(number);
        return false;
    }

    public void mergeRanges() {
        Set<Range> newRanges = new TreeSet<>();

        Iterator<Range> iterator = ranges.iterator();
        var current = iterator.next();

        while (iterator.hasNext()){
            var temp = iterator.next();
            // Sorted Set
            //left side of temp is greater than or equal to left side of current
            if(current.right < temp.left){
                newRanges.add(current);
                current = temp;
            } else if(current.right < temp.right){
                current = new Range(current.left, temp.right);
            }
        }
        newRanges.add(current);

        ranges = newRanges;
    }

    public long countIds() {
        long idsCount = 0;
        for(Range r: ranges){
            idsCount += (r.right - r.left +1);
        }
        return idsCount;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("\n");
        ranges.forEach(r -> sb
                .append('(')
                .append(r.left)
                .append(", ")
                .append(r.right)
                .append(")\n")
        );
        sb.append("\n");

        found.stream().sorted().forEach(n -> sb.append(n).append(", "));
        sb.append("\n");
        sb.append("Ranges: ").append(ranges.size()).append("\n");
        sb.append("In the range: ").append(found.size()).append("\n");
        sb.append("Out of the range: ").append(notFound.size());

        return sb.toString();
    }

}
