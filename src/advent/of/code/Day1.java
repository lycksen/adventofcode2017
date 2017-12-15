package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1 {

    public static void main(String[] args) throws IOException {
        String code = new String(Files.readAllBytes(Paths.get("src/resource//Day5.txt")));
        char[] chars = code.toCharArray();
        int i  = 1;
        char oldChar = chars[0];
        int sum = 0;
        while (i < chars.length) {
            char current = chars[i];
            if (current == oldChar) {
                sum += Character.getNumericValue(oldChar);
            }
            oldChar = current;
            i++;
        }
        //Last char
        if (oldChar == chars[0]) {
            sum += Character.getNumericValue(oldChar);
        }
        System.out.print(sum);
    }
}
