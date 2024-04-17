import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        openMessage();
        boolean quit = false;
        while (!quit) {
            if (newGame(sc) < 0) {
                Game.quickGame(sc);
                quit = keepPlaying(sc);
            } else {
                Player player = newPlayer(sc);
                System.out.println("Up until what level do you want to play?");
                int input = sc.nextInt();
                sc.nextLine();
                Game.setLvlToWin(input);
                int gameNo = 1;
                while (player.getLvl() < Game.getLvlToWin()) {
                    System.out.format("___________R O U N D   # %d ___________\n\n", gameNo);
                    Game.gameRound(sc, player);
                    gameNo++;
                }
                System.out.format("Congratulations, %s! You won the game.\n", player.getUsername());
                quit = keepPlaying(sc);
            }
        }
        System.out.println("Thank you for playing! See you next time :)");
    }


    static void openMessage() {
        System.out.println("___________________Rock__Paper__Scissors___________________");
        System.out.println();
        System.out.println("Hello there and welcome to a game of Rock-Paper-Scissors!");
        System.out.println("I will assume you are already familiar with the game mechanics so I will dive right in with what's new in here.");
        System.out.println("1. You can choose to either play a quick game of \"first to two\" or take the longer path and lvl up to win");
        System.out.println("2. If you choose to lvl up, you can select how many lvl you need in order to win the game.");
        System.out.println();
        System.out.println("Enough talking. Let's start playing now!");
        System.out.println("_________________________________________________________________________");
    }

    static boolean keepPlaying(Scanner sc) {
        System.out.println("Do you want to keep playing? (Y/N)");
        String input = sc.nextLine().toLowerCase();
        boolean validate = false;
        while (!validate) {
            if ("y".equals(input)) {
                System.out.println("As you wish.");
                validate = true;
            } else if ("n".equals(input)) {
                System.out.println("As you wish.");
                return true;
            } else {
                System.out.println("Y is for yes and N for no. You got that right? Let's try again:");
                input = sc.nextLine().toLowerCase();
            }
        }
        return false;
    }

    static Player newPlayer(Scanner sc) {
        System.out.println("First things first. If we're to keep track of your progress I need a name. How should I call you?");
        String name = sc.nextLine();
        boolean commit = false;
        while (!commit) {
            System.out.println("Are you happy with your choice? (Y/N)");
            String input = sc.nextLine().toLowerCase();
            if ("y".equals(input)) {
                commit = true;
            } else if ("n".equals(input)) {
                System.out.println("Try again:");
                name = sc.nextLine();
            } else {
                System.out.println("Y is for yes and N for no. You got that right? Let's try again:");
                input = sc.nextLine().toLowerCase();
            }
        }
        Player player = new Player(name);
        return player;
    }

    static int newGame(Scanner sc) {
        System.out.println("What do you want to play?");
        System.out.println("1. Quick game.");
        System.out.println("2. Longer game with leveling up.");
        int input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1: {
                System.out.println("A quick game shall be!");
                return -1;
            }
            case 2: {
                System.out.println("A long game shall be!");
                return 1;
            }
            default: {
                System.out.println("You think you're sneaky eh? A long game for you then! >:)");
                return 1;
            }
        }
    }
}

