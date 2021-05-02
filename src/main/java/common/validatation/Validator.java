package common.validatation;

public class Validator {
    static public void isValidStringLength(String target, String input, int min, int max){
        if(input.length() < min || input.length() > max) {
            throw new IllegalArgumentException("Invalid input length: " + target + " should be from " + min +  " to " + max);
        }
    }

    static public void isValidRange(String target, int input, int min, int max) {
        if(input < min || input > max) {
            throw new IllegalArgumentException("Invalid input range: " + target + " should be from " + min +  " to " + max);
        }
    }

    static public void isValidMinRange(String target, int input, int min) {
        if(input < min) {
            throw new IllegalArgumentException("Invalid input range: " + target + " should be bigger than " + min );
        }
    }
}
