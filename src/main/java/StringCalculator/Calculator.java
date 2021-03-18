package StringCalculator;

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

        for (String number : splitNumbers) {
            if (!number.trim().isEmpty()) {
                returnValue += Integer.parseInt(number.trim());
            }
        }
        return returnValue;
    }
    }

