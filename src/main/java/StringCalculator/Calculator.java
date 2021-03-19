package StringCalculator;

import java.util.ArrayList;

public class Calculator {


    int add(String numbers) {
        String delimiter = ",|\n";
        String noDelimiter = numbers;
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            noDelimiter = numbers.substring(numbers.indexOf("n") + 1);
        }

        return add(noDelimiter, delimiter);


    }


    private static int add(String numbers, String delimiter) {
        int returnValue = 0;
        String[] splitNumbers = numbers.split(delimiter);
        ArrayList<Integer> negative = new ArrayList<>();


        for (String splitNumber : splitNumbers) {

            if (!splitNumber.isEmpty()) {
                int nums = Integer.parseInt(splitNumber.trim());
                if (nums < 0) {
                    negative.add(nums);
                }
                returnValue += nums;
            }

        }

        if (negative.size() > 0) throw new RuntimeException("negatives not allowed" + negative);

        return returnValue;

    }
}


