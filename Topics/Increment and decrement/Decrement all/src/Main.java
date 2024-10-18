import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = new int[4];

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = scanner.nextInt() - 1;
            System.out.print(numArray[i] + " ");
        }
    }
}