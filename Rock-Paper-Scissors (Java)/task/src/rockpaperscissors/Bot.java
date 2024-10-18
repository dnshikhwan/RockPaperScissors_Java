package rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;

public class Bot {
    private String choice;

    public Bot(Random random, ArrayList<String> choices) {
        int numOfChoice = random.nextInt(choices.size());
        this.choice = choices.get(numOfChoice);
    }

    public String getChoice() {
        return choice;
    }
}
