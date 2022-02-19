package view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputPlayerCount() {
        return scanner.nextInt();
    }

    public int inputLadderHeight() {
        return scanner.nextInt();
    }
}
