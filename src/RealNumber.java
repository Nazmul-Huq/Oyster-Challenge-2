import java.util.Scanner;

public class RealNumber {

    /**
     * Check string contains other than 0-9, +, -, ., e character. If yes "given string is not number"
     * @param input
     * @return
     */
    static boolean isStringContainInvalidChar(String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ( !(c == '+' || c == '-' || c == '.' || c == 'e'  || ( c >= '0' && c <= '9') ) ){
                return true;
            }
        }
        return false;
    }


    /**
     * Check if there is any '+', '-', '.', 'e' at the end. If yes "given string is not number"
     * @param input
     * @return
     */
    static boolean isLastCharPlusMinusDotE(String input){
        char lastChar = input.charAt(input.length()-1);
        if (lastChar == '+' || lastChar == '-' || lastChar == '.' || lastChar == 'e') {
            return true;
        }
        return false;
    }


    /**
     * Check if there is more than one  '+', '-', '.', 'e'. If yes "given string is not number"
     * @param input
     * @return
     */
    static boolean  isNumberOfSymbolOk(String input){
        int numberOfPlus = 0;
        int numberOfMinus = 0;
        int numberOfDot = 0;
        int numberOfE = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                numberOfPlus += 1;
            } else if (input.charAt(i) == '-') {
                numberOfMinus +=1;
            } else if (input.charAt(i) == '.') {
                numberOfDot +=1;
            } else if (input.charAt(i) == 'e') {
                numberOfE +=1;
            }
        }
        if (numberOfPlus > 1 || numberOfMinus > 1 || numberOfDot > 1 || numberOfE> 1) {
            return true;
        }
        return false;
    }

    /**
     * Check if 'e' present in the string or not
     * @param input
     * @return
     */
    static boolean isThereE(String input){
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'e') {
                return true;
            }
        }
        return false;
    }

    // Check if there is any '+' or '-' sign not at position 0. If yes "given string is not number"
    static boolean isPlusMinusNotAtIndex0(String input){
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ( (c == '+' || c == '-' ) && i !=0) {
                return true;
            }
        }
        return false;
    }

    //Rule- 1: check if after 'e' there is a digit or not. If not "given string is not number"
    static boolean isThereDigitAfterE(String input){
        int positionOfE = getPositionOfE(input);

        // if 'e' is at the end of the string
        if (positionOfE == input.length()-1) {
            return false;

        }

        // if there is no digit after 'e'
        if (input.charAt(positionOfE+1) < '0' && input.charAt(positionOfE+1) > '9') {
            return false;
        }
        return true;
    }

    static int getPositionOfDot(String input){
        int positionOfDot = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.') {
                positionOfDot = i;
                break;
            }
        }
        return positionOfDot;
    }

    static int getPositionOfE(String input){
        int positionOfE = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'e') {
                positionOfE = i;
                break;
            }
        }
        return positionOfE;
    }




    /**
     *
     * @param input
     */
    static String removeWhiteSpace(String input){
        if (input.charAt(0) == ' ') {
            input = input.substring(1);
        }
        if (input.charAt(input.length()-1) == ' ') {
            input = input.substring(0, input.length()-1);
        }
        return input;
    }


    /**
     * check if given string is a number or not
     * @param input
     * @return
     */
    static boolean isStringNumber(String input){

        //Step- 1: Check string contains other than '0~9', '+', '-', '.', 'e' character. If yes "given string is not number"
        if (isStringContainInvalidChar(input)){
            System.out.println("Not number: contain other than +-.e:");
            return false;
        }

        //Step- 2: Now, check if there is any '+', '-', '.', 'e' at the end. If yes "given string is not number"
        if (isLastCharPlusMinusDotE(input)) {
            System.out.println("Not number: +-.e at the end ");
            return false;
        }

        //Step- 3: Check if there is more than one  '+', '-', '.', 'e'. If yes "given string is not number"
        if (isNumberOfSymbolOk(input)){
            System.out.println("Not number: +-.e more than once");
            return false;
        }


        //Step- 4: Check if 'e' present in the string or not
        // if yes, run the if blok
        // if not, run the else block
        if (isThereE(input)) {

            //Rule- 1: check if after 'e' there is a digit or not. If not "given string is not number"
            if (!isThereDigitAfterE(input)){
                System.out.println("Not number: no digit after e ");
                return false;
            }


            //Rule- 2: Get position of dot (if any)
            int positionOfDot = getPositionOfDot(input);

            //Rule- 3: if position of dot is  0, return false, else follow next rules
            if (positionOfDot  == 0) {
                System.out.println("Not number: a dot is in the beginning");
                return false;
            }

            //Rule- 4: check if '.' appear after 'e' or not. If yes "given string is not number"
            int positionOfE = getPositionOfE(input);
            if (positionOfE < positionOfDot){
                System.out.println("Not number: dot appear after e ");
                return false;
            }

        } else {

            // Check if there is any '+' or '-' sign not at position 0. If yes "given string is not number"
            if (isPlusMinusNotAtIndex0(input)){
                System.out.println("Not number: + - not at beginning");
                return false;
            }

        }


        return true;
    }



    public static void main(String[] args) {

        /**
         * Step- 1: Check string contains other than 0-9, +, -, ., e character. If yes "given string is not number"
         * Step- 2: Check if there is any '+', '-', '.', 'e' at the end. If yes "given string is not number"
         * Step- 3: Check if there is more than one  '+', '-', '.', 'e'. If yes "given string is not number"
         * Step- 4: Check if 'e' present in the string or not
         *          if yes, check if 'e' has followed rules of scientific notation or not
         *          Rule- 1: check if after 'e' there is a digit or not. If not "given string is not number"
         *          Rule- 2: get position of dot (if any).
         *          Rule- 3: if position of dot is <= 0, return false, else follow next rules
         *          Rule- 4: check if '.' appear after 'e' or not. If yes "given string is not number"
         *

         *          if not ( we have already ruled out: no signs exist at end, not more than once )
         *          Step- :Check if there is any '+' or '-' sign not at position 0. If yes "given string is not number"
         */


        // get the input and remove any white space at the beginning and end
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string to check if it is a real number or not");
        String input = scanner.nextLine();
        input = removeWhiteSpace(input);

        // check if given string is a number or not
        System.out.println("Is given string a number? " + isStringNumber(input));


    } // main() ends here

} // clas ends here
