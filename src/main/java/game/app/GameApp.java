package game.app;

import game.core.GamePlayer;

import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner inputScanner = new Scanner(System.in);
        GamePlayer gamePlayer = getGamePlayer(inputScanner);

        System.out.println("시도할 회수는 몇회인가요?");
        gamePlayer.playGame(getTryCount(inputScanner));
    }

    private static GamePlayer getGamePlayer(Scanner inputScanner) {
        GamePlayer gamePlayer = null;
        while(gamePlayer == null) {
            gamePlayer = startGame(inputScanner);
        }

        return gamePlayer;
    }

    private static GamePlayer startGame(Scanner inputScanner) {
        try {
            return new GamePlayer(inputScanner.nextLine());
        }catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return null;
        }
    }

    private static int getTryCount(Scanner inputScanner) {
        int tryCount = -1;
        while(tryCount < 0) {
            tryCount = inputTryCount(inputScanner);
        }

        return tryCount;
    }

    private static int inputTryCount(Scanner inputScanner) {
        try {
            String nextLine = inputScanner.nextLine();
            return Integer.parseInt(nextLine);
        }catch(NumberFormatException ime) {
            System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
            return -1;
        }
    }
}
