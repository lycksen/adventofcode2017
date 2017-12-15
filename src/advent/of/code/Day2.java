package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day2 {
    
    public static void main(String[] args) throws IOException {
        String spreadSheet = new String(Files.readAllBytes(Paths.get("src/resource//Day5.txt")));
        
        Integer checkSum = 0;
        Scanner scanner = new Scanner(spreadSheet);
        while (scanner.hasNextLine()) {
            List<Integer> numbers = Arrays.stream(Arrays.stream(scanner.nextLine().split("\t"))
                                                        .mapToInt(Integer::parseInt).toArray())
                                                    .boxed().collect(Collectors.toList());
            Integer max = numbers.stream().max(Integer::compareTo).get();
            Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
            checkSum += (max - min);
        }
        scanner.close();
        System.out.print(checkSum);
    }
}
