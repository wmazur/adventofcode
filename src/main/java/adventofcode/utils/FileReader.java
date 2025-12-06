package adventofcode.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> readFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
        return new ArrayList<>(Files.readAllLines(file.toPath()));
    }

    public static String[] splitOn(String string){
        return splitOn(string, ",");
    }

    public static String[] splitOn(String string, String separator){
        return string.split(separator);
    }

    public static int[] splitOnDigits(String string){
        int[] retVal = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
                retVal[i] = string.charAt(i)-'0';
        }
        return retVal;
    }

}
