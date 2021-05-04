package common.code;

/**
 * @brief
 * Game 공통 에러 코드
 */
public enum GameErrorCode {
    INVALID_LENGTH_OF_CAR_NAME("Length of a car name should be from 1 to 5."),
    INVALID_RANGE_OF_MOVING_NUMBER("Moving number should be from 0 to 9."),
    INSUFFICIENT_NUMBER_OF_CAR("Number of cars should be bigger than 1."),
    EMPTY_CAR_NAME("Car name should not be empty."),
    INVALID_CAR_INPUT_FORMAT("Input of car name is wrong."),
    INVALID_RANGE_OF_TRY_COUNT("Try count should be bigger than 0."),
    DUPLICATED_CAR_NAME("Car name should net be duplicated.");

    private String errorMessage;

    GameErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
