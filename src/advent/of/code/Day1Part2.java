package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1Part2 {
    
    public static void main(String[] args) throws IOException {
        String code = new String(Files.readAllBytes(Paths.get("src/resource//Day5.txt")));
        char[] chars = code.toCharArray();
        int jump = chars.length / 2;
        int i  = 0;
        char oldChar = chars[0];
        int sum = 0;
        while (i < chars.length) {
            char current = chars[i];
            int x = i+jump;
            if (x >= chars.length) {
                int rest = chars.length - i;
                x = jump - rest;
            }
            if (current == chars[x]) {
                sum += Character.getNumericValue(current);
            }
            oldChar = current;
            i++;
        }
        //Last char
        if (oldChar == chars[jump]) {
            sum += Character.getNumericValue(oldChar);
        }
        System.out.print(sum);
    }
}
