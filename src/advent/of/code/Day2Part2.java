package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day2Part2 {
    public static void main(String[] args) throws IOException {
        String spreadSheet = new String(Files.readAllBytes(Paths.get("src/resource//Day5.txt")));
        Integer checkSum = 0;
        Scanner scanner = new Scanner(spreadSheet);
        while (scanner.hasNextLine()) {
            List<Integer> numbers = Arrays.stream(Arrays.stream(scanner.nextLine().split("\t"))
                                                        .mapToInt(Integer::parseInt).toArray())
                                          .boxed().collect(Collectors.toList());
            for(Integer number : numbers) {
                checkSum += numbers.stream().filter(num -> (number != num && number % num  == 0))
                                   .reduce(0, (sum, num) -> sum += number / num);
            }
        }
        scanner.close();
        System.out.print(checkSum);
    }
}
