package game.app;

import game.core.GamePlayer;

import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner inputScanner = new Scanner(System.in);
        String carNameInput = inputScanner.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = inputScanner.nextInt();

        GamePlayer gamePlayer = new GamePlayer(tryCount, carNameInput);
        gamePlayer.plyaGame();
    }
}
