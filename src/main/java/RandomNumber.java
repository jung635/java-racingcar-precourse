import java.util.Random;

public class RandomNumber {
    static public int generateRandomNumber() {
        Random random = new Random(System.currentTimeMillis());
        return random.nextInt(10);
    }
}
