import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int max = Integer.MAX_VALUE;
        int seed = 0;
        // create a random with seed range a-b
        for (int i = a; i <= b; i++) {
            Random random = new Random(i);
            int currentMax = 0;
            for (int j = 0; j < n; j++) {
                // for each generated random number from the seed, find the max and save it in an array
                int randomNumber = random.nextInt(k);
                if (randomNumber > currentMax) {
                    currentMax = randomNumber;
                }
            }

            // find seed that generate random number from 0 to K (exclusive), based on array of max, find the min
            if (currentMax < max) {
                max = currentMax;
                seed = i;
            }
        }


        // output the seed and the max generated number
        System.out.println(seed);
        System.out.println(max);
    }
}