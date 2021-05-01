public class CarsValidator {
    public void isValidNameOfCarLength(String carName){
        if(carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException("Length of name of car should be from 1 to 5.");
        }
    }

    public void isValidInputPostionRange(int inputPostion) {
        if(inputPostion < 0 || inputPostion > 9) {
            throw new IllegalArgumentException("Input of position of car should be from 0 to 9.");
        }
    }
}
