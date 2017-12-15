package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5Part2 {
    public static void main (String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/resource//Day5.txt")));

        Scanner scanner = new Scanner(input);
        List<Integer> ints = new ArrayList<>();
        while (scanner.hasNextLine()){
            ints.add(Integer.parseInt(scanner.nextLine()));
        }
        int index = 0;
        int current = ints.get(index);
        int i = 0;
        while (true) {
            ints.set(index, current+1);
            index = index + current;
            if (index >= ints.size()) {
                i++;
                break;
            }
            current = ints.get(index);
            i++;
        }
        System.out.print(i);
    }
}
