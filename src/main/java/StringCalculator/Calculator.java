package StringCalculator;

public class Calculator {


    int add(String numbers){
        int returnVal = 0;


        numbers = numbers.replace("\n", ",");
        String[] numbersArray = numbers.split(",");




        for (String number : numbersArray) {

            returnVal += Integer.parseInt(number.trim());

        }
        return returnVal;

    }
}
