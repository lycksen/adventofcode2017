package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day8 {
    static String inc = "inc";
    static String dec = "dec";
    static String gt = ">";
    static String lt = "<";
    static String lte = "<=";
    static String gte = ">=";
    static String equals = "==";
    static String notEquals = "!=";

    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/resource//Day8.txt")));
        HashMap<String, Integer> variables = new HashMap<>();
        int highestValue = 0;
        
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {

            String[] ifs = scanner.nextLine().split("if");
            String[] exp = ifs[0].split(" ");
            List<String> ifExp = Arrays.stream(ifs[1].split(" ")).filter(s -> !s.isEmpty()).map(String::trim)
                                       .collect(Collectors.toList());
            
            String variableToHandle = exp[0];
            int value = getValue(variables, variableToHandle);
            int ifValue = getValue(variables, ifExp.get(0));
            
            value = getNewValue(ifExp, value, ifValue, exp);
            highestValue = value > highestValue ? value : highestValue;
            variables.put(variableToHandle, value);
        }

        System.out.println("Part1: Highest value after read: " + variables.values().stream().max(Integer::compareTo).get());
        System.out.println("Part2: Highest value during read: " + highestValue);
    }

    private static int getValue(HashMap<String, Integer> variables, String variable) {
        int value = 0;
        if (variables.containsKey(variable)) {
            value = variables.get(variable);
        }
        return value;
    }

    private static int getNewValue(List<String> ifExp, int value, int ifValue, String[] exp) {
        String operator = exp[1];
        int operatorValue = Integer.parseInt(exp[2]);
        String check = ifExp.get(1);
        int checkValue = Integer.parseInt(ifExp.get(2));
        
        if (check.equalsIgnoreCase(gt)) {
            if (ifValue > checkValue) {
                value = getOperatedValue(inc, dec, value, operator, operatorValue);
            }
        } else if (check.equalsIgnoreCase(lt)) {
            if (ifValue < checkValue) {
                value = getOperatedValue(inc, dec, value, operator, operatorValue);
            }
        } else if (check.equalsIgnoreCase(lte)) {
            if (ifValue <= checkValue) {
                value = getOperatedValue(inc, dec, value, operator, operatorValue);
            }
        } else if (check.equalsIgnoreCase(gte)) {
            if (ifValue >= checkValue) {
                value = getOperatedValue(inc, dec, value, operator, operatorValue);
            }
        } else if (check.equalsIgnoreCase(equals)) {
            if (ifValue == checkValue) {
                value = getOperatedValue(inc, dec, value, operator, operatorValue);
            }
        } else if (check.equalsIgnoreCase(notEquals)) {
            if (ifValue != checkValue) {
                value = getOperatedValue(inc, dec, value, operator, operatorValue);
            }
        }
        return value;
    }

    private static int getOperatedValue(String inc, String dec, int value, String operator, int operatorValue) {
        if (operator.equalsIgnoreCase(inc)) {
            value += operatorValue;
        } else if (operator.equalsIgnoreCase(dec)) {
            value -= operatorValue;
        }
        return value;
    }
}