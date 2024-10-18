import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();


        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 'a') {
                inputArray[i] = 'b';
            }
        }

        String result = String.valueOf(inputArray);
        System.out.println(result);


        scanner.close();

    }
}