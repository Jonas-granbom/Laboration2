package StringCalculator;

import java.util.ArrayList;

public class Calculator {


    int add(String numbers) {
        String delimiter = ",|\n";
        String noDelimiter = numbers;
        if (numbers.startsWith("//")) {

            int delimiterIndex = numbers.indexOf("//") + 2;
            int delimiterIndexEnd = numbers.indexOf("\n");


            delimiter = numbers.substring(delimiterIndex, delimiterIndexEnd);
            String[] newDelimiters = delimiter.split("]");

            numbers = numbers.replace("//", "");
            numbers = numbers.replace(delimiter, "");
            numbers = numbers.replace("\n", ",");


            for (int i = 0; i < newDelimiters.length; i++) {

                newDelimiters[i] = newDelimiters[i].replace("[", "");

            }


            for (String newDelimiter : newDelimiters) {
                numbers = numbers.replace(newDelimiter, ",");

            }


            noDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
            delimiter = ",";

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

                } else if (nums <= 1000) returnValue += nums;
            }

        }

        if (negative.size() > 0) throw new RuntimeException("negatives not allowed" + negative);

        return returnValue;

    }
}


