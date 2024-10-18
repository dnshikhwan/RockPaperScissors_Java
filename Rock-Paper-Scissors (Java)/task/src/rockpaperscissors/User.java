package rockpaperscissors;

public class User {
    private String name;
    private String choice;
    private int score;

    public User(String name, String choice) {
        this.name = name;
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
