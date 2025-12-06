package adventofcode.y2025.a03;

import java.util.List;

import static adventofcode.y2025.utils.FileReader.splitOnDigits;

public class Solution01 {

    private final int numberOfDigits;


    public Solution01(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }



    public long solve(List<String> inputs){
        long sum = 0;
        for (String s : inputs){
            var input = splitOnDigits(s);
            SolveOneArray solver = new SolveOneArray(input, numberOfDigits);
            sum += solver.solve();
        }
        return sum;
    }


}
