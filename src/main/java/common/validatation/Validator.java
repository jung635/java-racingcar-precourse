package common.validatation;

public class Validator {
    public void isValidLength(String target, String carName, int min, int max){
        if(carName.length() < min || carName.length() > max) {
            throw new IllegalArgumentException("Invalid input length: " + target + " should be from " + min +  " to " + max);
        }
    }

    public void isValidRange(String target, int inputPostion, int min, int max) {
        if(inputPostion < min || inputPostion > max) {
            throw new IllegalArgumentException("Invalid input range: " + target + " should be from " + min +  " to " + max);
        }
    }
}
