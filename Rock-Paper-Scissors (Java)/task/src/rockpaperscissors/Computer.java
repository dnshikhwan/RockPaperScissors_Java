package rockpaperscissors;

import java.util.Random;

public class Computer {
    private String choice;

    public Computer(Random random) {
        int numOfChoice = random.nextInt(3);
        switch (numOfChoice) {
            case 0:
                this.choice = "rock";
                break;
            case 1:
                this.choice = "paper";
                break;
            case 2:
                this.choice = "scissors";
                break;
        }
    }


    public String getChoice() {
        return choice;
    }
}
