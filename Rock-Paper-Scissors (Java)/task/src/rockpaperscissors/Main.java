package rockpaperscissors;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // request user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        String choice = "";
        User user = new User(name, choice);


        // greet user
        System.out.println("Hello, " + user.getName());

        // get options for game
        String option = scanner.nextLine();
        ArrayList<String> choices = new ArrayList<>();

        if (option.isEmpty()) {
            choices.addAll(Arrays.asList("rock", "paper", "scissors"));
        } else {
            String[] userChoices = option.split(",");
            choices.addAll(Arrays.asList(userChoices));
        }

        // read rating.txt and if user exists, print score, if not start score from 0
//        String filePath = ".\\Rock-Paper-Scissors (Java)\\task\\src\\rockpaperscissors\\rating.txt";
        String filePath = "rating.txt";
        File file = new File(filePath);

        // use scanner with try-with-resources block to avoid resource leak
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String content = sc.nextLine();
                String[] splittedContent = content.split(" ");
                // splitted content[0] -> name
                // splitted content[1] -> score
                if (splittedContent[0].equals(user.getName())) {
                    int currentScore = Integer.parseInt(splittedContent[1]);
                    user.setScore(currentScore);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        System.out.println("Okay, let's start");

        // play the game
        while (!choice.equals("!exit")) {
            choice = scanner.nextLine();

            switch (choice) {
                // if user input !exit, output Bye! and stop the game
                case "!exit":
                    writeScoreInFile(user, filePath);
                    System.out.println("Bye!");
                    break;
                case "!rating":
                    System.out.println("Your rating: " + user.getScore());
                    break;
                default:
                    if (choices.contains(choice)) {
                        // initialize new bot everytime the loop runs
                        Random random = new Random();
                        Bot bot = new Bot(random, choices);

                        // set the user's choice
                        user.setChoice(choice);
                        findWinner(user, bot, choices);
                    } else {
                        System.out.println("Invalid input");
                    }
                    break;
            }
        }


        scanner.close();
    }

    public static void findWinner(User user, Bot bot, ArrayList<String> choices) {
        String userChoice = user.getChoice();
        String botChoice = bot.getChoice();

        // array of choices

        // use list instead, because can use contains method
        ArrayList<String> lose = new ArrayList<>();
        int loseLength = (choices.size() - 1) / 2;
        ArrayList<String> win = new ArrayList<>();

        // find the index of user choice in the array of choices
        for (int i = 0; i < choices.size(); i++) {
            if (choices.get(i).equals(userChoice)) {
                for (int j = 0, n = 1; j < loseLength; j++, n++) {
                    lose.add(choices.get((i + n) % choices.size()));
                }
            }
        }

        // assign remaining into win array
        for (int i = 0; i < choices.size(); i++) {
            // add a flag
            boolean isInLose = false;
            for (int j = 0; j < loseLength; j++) {
                // if choices = lose, set the flag = true, and break from the loop
                if (choices.get(i).equals(lose.get(j))) {
                    isInLose = true;
                    break;
                }
            }

            if (!isInLose && !choices.get(i).equals(userChoice)) {
                win.add(choices.get(i));
            }
        }

        boolean botWon = win.contains(botChoice);


        if (userChoice.equals(botChoice)) {
            System.out.println("There is a draw (" + userChoice + ")");
            // if draws, add 50
            user.setScore(user.getScore() + 50);
        } else if (botWon) {
            System.out.println("Well done. The computer chose " + botChoice + " and failed");
            // if won, add 100
            user.setScore(user.getScore() + 100);
        } else {
            // if loses, don't change anything
            System.out.println("Sorry, but the computer chose " + botChoice);
        }
    }

    public static void writeScoreInFile(User user, String filepath){
        // get user's name and score
        File file = new File(filepath);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write("\n" + user.getName() + " " + user.getScore());
        } catch (IOException e) {
            System.out.printf("An exception occurred &s", e.getMessage());
        }

    }
}
