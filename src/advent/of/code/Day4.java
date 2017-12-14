package advent.of.code;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) throws IOException {
        String input = "aa bb cc dd ee\n" 
                + "aa bb cc dd aa\n" 
                + "aa bb cc dd aaa";
        
        Scanner scanner = new Scanner(input);
        int valid = 0;
        while (scanner.hasNextLine()){
           List<String> list = Arrays.asList(scanner.nextLine().split(" "));
           int duplicates = 0; 
           for (String word : list) {
              if (Collections.frequency(list, word) > 1) {
                  duplicates++;
              }
           }
           if (duplicates == 0) {
               valid++;
           }
        }
        System.out.print(valid);
    }
}
