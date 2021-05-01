package game.core;

import common.validatation.CarsValidator;

public class Cars {
    CarsValidator carsValidator = new CarsValidator();

    private String name;
    private int position;

    public Cars(String name) {
        carsValidator.isValidNameOfCarLength(name);

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
        carsValidator.isValidInputPostionRange(inputPostion);
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
