import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static int lvlToWin;
    private static final int roundXp = 5;
    private static final int gameXp = 10;

    public static void setLvlToWin(int value) {
        lvlToWin = value;
    }

    public static int getLvlToWin() {
        return lvlToWin;
    }

    public static int getRoundXp() {
        return roundXp;
    }
    public static int getGameXp() {
        return gameXp;
    }

    public static void gameRound(Scanner sc, Player player) {
        int compScore = 0;
        while (compScore != 2 && player.getRoundScore() != 2) {
            int score = quickGame(sc);
            if (score > 0) {
                player.addRoundScore(1);
                player.addXp(roundXp);
            } else if (score < 0) {
                compScore++;
            }
            System.out.format("%s's score: %d\nMy score: %d\n",player.getUsername(),
                    player.getRoundScore(), compScore);
        }
        if (player.getRoundScore() == 2) {
            System.out.println("You won the round!");
            player.addXp(gameXp);
        }
        player.resetScore();
    }
    public static int quickGame(Scanner sc) {
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
            System.out.format("You chose %s and I chose %s. You won.\n\n", RPS.get(playerInput - 1), RPS.get(computerInput));
            return 1;
        }
        if (playerInput == computerInput + 1) {
            System.out.format("You chose %s and I chose %s. Looks like it's a draw.\n\n", RPS.get(playerInput - 1), RPS.get(computerInput));
            return 0;
        }
        System.out.format("You chose %s and I chose %s. You didn't win this time.\n\n", RPS.get(playerInput - 1), RPS.get(computerInput));
        return -1;
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
