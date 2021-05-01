package game.core;

import common.validatation.Validator;

public class Cars {
    Validator validator = new Validator();

    private String name;
    private int position;

    final static int MAX_LENGTH_CAR_NAME = 1;
    final static int MIN_LENGTH_CAR_NAME = 5;

    public Cars(String name) {
        validator.isValidLength("Name of cars", name, 1, 5);

        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int inputPostion){
        validator.isValidRange("Position of cars", inputPostion, 0, 9);
        if(isForward(inputPostion)) {
            this.position ++;
        }
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4 && randomNumber <=9;
    }

    @Override
    public String toString() {
        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(this.name + ":");
        for(int i=0; i<this.position; i++) {
            resultMessageBuilder.append("-");
        }
        return resultMessageBuilder.toString();
    }
}
