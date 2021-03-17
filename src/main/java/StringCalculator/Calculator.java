package StringCalculator;

public class Calculator {


    int add(String numbers){
        int returnVal = 0;
        String[] numbersArray = numbers.split(",");

        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to two numbers separated by comma is allowed");
        }
        for (String number : numbersArray) {

            returnVal += Integer.parseInt(number.trim());

        }
        return returnVal;

    }
}
