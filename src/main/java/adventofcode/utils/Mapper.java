package adventofcode.utils;


public class Mapper {


    public static <R> String iterableToString(Iterable<R> input){
        StringBuilder output = new StringBuilder();
        for(R r: input){
            output.append(r).append(' ');
        }
        return output.toString();
    }

    public static <R> String arrayToString(R[] input){
        StringBuilder output = new StringBuilder();
        for(R r: input){
            output.append(r).append(' ');
        }
        return output.toString();
    }

    public static Matrix<Character> fromMultilineStringToChars(String input) {
        return fromStringsToChars(input.split("\n"));
    }

    public static Matrix<Character> fromStringsToChars(String[] input) {
        var arrays = new Character[input.length][];
        int rownum = 0;
        for (String s : input) {
            var row = new Character[s.length()];
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                row[i] = charArray[i];
            }

            arrays[rownum++] = row;
        }
        return new Matrix<>(arrays);
    }
}
