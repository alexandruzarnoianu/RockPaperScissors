public class Player {

    private String username;
    private int roundScore;
    private int gameScore;
    private int xp;
    private int lvl;

    public Player() {

    }
    public Player(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public int getXp() {
        return xp;
    }

    public int getLvl() {
        return lvl;
    }


    public void addXp(int value) {
        this.xp += value;
        System.out.format("Congratulations! You just received %d xp.\n", value);
        if (isLvlUp()) {
            this.xp -= this.lvl * 10 - 15;
            this.lvl++;
            System.out.println("Even more congratulations! You are now level " + this.lvl);
        }
    }

    private boolean isLvlUp() {
        int xpToLvlUp = this.lvl * 10 + 15;
        return this.xp >= xpToLvlUp;
    }
}
