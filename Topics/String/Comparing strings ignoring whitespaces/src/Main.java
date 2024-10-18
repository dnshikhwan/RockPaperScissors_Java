import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

        System.out.println(firstString.trim().replace(" ", "").equals(secondString.trim().replace(" ", "")));

        scanner.close();
    }
}