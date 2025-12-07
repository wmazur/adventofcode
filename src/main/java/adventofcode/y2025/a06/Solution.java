package adventofcode.y2025.a06;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
public class Solution {
    
//    public long[] solve(List<String> input){
//        getOperations(input);
//    }

    public long solve01(List<String> input) {
        long sum = 0L;
        String[][] rows = new String[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            rows[i] = input.get(i).trim().split(" +");
        }
        String[] operations = rows[input.size()-1];

        for (int i = 0; i < operations.length; i++) {
            Long[] column = new Long[input.size()-1];
            for (int j = 0; j < input.size() - 1; j++) {
                column[j] = Long.parseLong(rows[j][i]);
            }
            sum += calculate(operations[i], column);
        }
        return sum;
    }

    public long solve02(List<String> input){
        long sum = 0;
        // Assumption - all rows have the same size
        int rowNum = input.size();
        int lastIndex = input.getFirst().length()-1;
        List<Long> numbers = new ArrayList<>();
        for(int i = lastIndex; i >=0 ; i--) {
            Long number = 0L;
            for (int j = 0; j < rowNum; j++) {
                char x = input.get(j).charAt(i);
                if(x == ' '){
                    continue;
                } else if(x == '+' || x == '*'){
                    numbers.add(Long.valueOf(number));
                    number = 0L;
                    log.info("{} {}", numbers, x);
                    sum += calculate(""+x, numbers.toArray(new Long[0]));
                    numbers = new ArrayList<>();
                } else {
                    var digit = x - '0';
                    number = number * 10 + digit;
                }
            }
            if(number != 0L){
                numbers.add(number);
//                log.info("{}", number);
            }
        }
        return sum;
    }

    public long calculate(String operator, Long[] numbers){
        if(Objects.equals(operator, "+")){
            return Arrays.stream(numbers)
                    .reduce(0L, Long::sum);
        } else if(Objects.equals(operator, "*")){
            return Arrays.stream(numbers)
                    .reduce(1L, (a,b) -> a*b);
        } else {
            throw new IllegalArgumentException(operator);
        }
    }
}
