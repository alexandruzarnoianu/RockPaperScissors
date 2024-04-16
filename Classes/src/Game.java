import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int lvlToWin;
    private static final int roundXp = 5;
    private static final int gameXp = 10;

    public Game(int lvlToWin) {
        this.lvlToWin = lvlToWin;
    }

    public int getLvlToWin() {
        return lvlToWin;
    }

    public static int getRoundXp() {
        return roundXp;
    }
    public static int getGameXp() {
        return gameXp;
    }

    public static boolean quickGame(Scanner sc) {
        Random random = new Random();
        HashMap<Integer, String> RPS = new HashMap<Integer, String>();
        RPS.put(0, "Rock");
        RPS.put(1, "Paper");
        RPS.put(2, "Scissors");
        System.out.println("Let's start the round. What do you want to be?\n\t1. Rock\n\t2. Paper\n\t3.Scissors");
        int playerInput = sc.nextInt();
        sc.nextLine();
        while (playerInput < 1 || playerInput > 3) {
            System.out.println("There are only 3 options. Please choose a valid one: (1 - rock; 2 - paper; 3 - scissors)");
            playerInput = sc.nextInt();
            sc.nextLine();
        }
        int computerInput = random.nextInt(3);
        boolean playerWon = playerWonRound(playerInput, computerInput);
        if (playerWon) {
            System.out.format("You chose %s and I chose %s. You won.", RPS.get(playerInput - 1), RPS.get(computerInput));
            return true;
        }
        System.out.format("You chose %s and I chose %s. You didn't win this time.", RPS.get(playerInput - 1), RPS.get(computerInput));
        return false;
    }

    private static boolean playerWonRound(int playerInput, int computerInput) {
        boolean result = false;
        switch (playerInput) {
            case 1: {
                if (computerInput == 2) {
                    result = true;
                }
                break;
            }
            case 2: {
                if (computerInput == 0) {
                    result = true;
                }
                break;
            }
            case 3: {
                if (computerInput == 1) {
                    result = true;
                }
                break;
            }
        }
        return result;
    }
}
