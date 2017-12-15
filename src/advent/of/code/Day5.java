package advent.of.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    
    public static void main (String[] args) {
        String input = "0\n"
                + "3\n"
                + "0\n"
                + "1\n"
                + "-3";

        Scanner scanner = new Scanner(input);
        List<Integer> ints = new ArrayList<>();
        while (scanner.hasNextLine()){
            ints.add(Integer.parseInt(scanner.nextLine()));
        }
        int index = 0;
        int current = ints.get(index);
        int jumps = 0;
        while (true) {
            ints.set(index, current+1);
            index = index + current;
            if (index >= ints.size()) {
                jumps++;
                break;
            }
            current = ints.get(index);
            jumps++;
        }
        System.out.print(jumps);        
    }
}
