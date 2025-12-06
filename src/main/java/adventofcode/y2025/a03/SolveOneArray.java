package adventofcode.y2025.a03;

import lombok.Getter;

public class SolveOneArray {

    private final int[] voltages;
    private final int numberOfDigits;

    private int[] location;
    @Getter
    private long[] value;

    public SolveOneArray(int[] voltages, int numberOfDigits) {
        this.voltages = voltages;
        this.numberOfDigits = numberOfDigits;
        if(numberOfDigits > voltages.length)
            throw new IllegalArgumentException();
        init();
    }

    private void init(){
        this.location = new int[numberOfDigits];
        this.value = new long[numberOfDigits];

        for (int i = 0; i <numberOfDigits; i++) {
            location[i] = voltages.length - (numberOfDigits - i);
        }
    }

    public long solve(){
//        int length = voltages.length;
//        int yLoc = length - 1;
//        int x = voltages[length - 2];
//        int y = voltages[yLoc];

        solve(0);

//        for(int i = length-2; i >= 0; i--){
//            if(voltages[i] >= x){
//                x = voltages[i];
////                xLoc = i;
//                for(int j = yLoc; j > i; j--){
//                    if(voltages[j] > y){
//                        y = voltages[j];
//                        yLoc = j;
//                    }
//                }
//            }
//        }
        return sum();
    }

    private void solve(int digitNumber) {
        if(digitNumber >= numberOfDigits)
            return;

        int lowerBound = digitNumber > 0 ? Math.max(digitNumber, location[digitNumber -1] +1) : 0;

        for(int i = location[digitNumber]; i >= lowerBound; i--){
            if(voltages[i] >= value[digitNumber]){
                value[digitNumber] = voltages[i];
                location[digitNumber] = i;
                solve(digitNumber + 1);
            }
        }
    }

    private long sum() {
        long sum = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            sum = sum * 10 + value[i];
        }
        return sum;
    }
}
