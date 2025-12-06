package adventofcode.y2025.a03;

import java.util.List;

import static adventofcode.y2025.utils.FileReader.splitOnDigits;

public class Solution01 {

    public int solve(List<String> inputs){
        int sum = 0;
        for (String s : inputs){
            var input = splitOnDigits(s);
            sum += solve(input);
        }
        return sum;
    }

    public int solve(int[] voltages){
        int length = voltages.length;
        int xLoc = length - 2;
        int yLoc = length - 1;
        int x = voltages[xLoc];
        int y = voltages[yLoc];
        for(int i = length-2; i >= 0; i--){
            if(voltages[i] >= x){
                x = voltages[i];
//                xLoc = i;
                for(int j = yLoc; j > i; j--){
                    if(voltages[j] > y){
                        y = voltages[j];
                        yLoc = j;
                    }
                }
            }
        }
        return x*10 +y;
    }
}
