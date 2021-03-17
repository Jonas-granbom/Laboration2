package StringCalculator;

public class Calculator {


    int add(String numbers){
        int returnVal = 0;
        String[] numbersArray = numbers.split(",");


        for (String number : numbersArray) {

            returnVal += Integer.parseInt(number.trim());

        }
        return returnVal;

    }
}
