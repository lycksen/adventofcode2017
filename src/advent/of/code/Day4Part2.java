package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day4Part2 {
    
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/resource//Day4.txt")));

        Scanner scanner = new Scanner(input);
        int valid = 0;
        while (scanner.hasNextLine()){
            List<String> row = Arrays.asList(scanner.nextLine().split(" "));
            int duplicates = 0;
            List<String> sortedRow  = row.stream().map(word -> sortString(word)).collect(Collectors.toList());
            for (String word : sortedRow) {
                if (Collections.frequency(sortedRow, word) > 1) {
                    duplicates++;
                }
            }
            if (duplicates == 0) {
                valid++;
            }
        }
        System.out.print(valid);
    }

    private static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
