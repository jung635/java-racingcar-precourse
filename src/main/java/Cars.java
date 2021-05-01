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
            this.position += inputPostion;
        }
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4 && randomNumber <=9;
    }

}
