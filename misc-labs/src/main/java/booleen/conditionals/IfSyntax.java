package booleen.conditionals;

import java.util.Scanner;

public class IfSyntax {
    public static void main(String[] args) {
        while (true) {
            System.out.println("input x: ");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            if (x == 10) System.out.println("Bingo \"if\" x = 10");
            else if (x == 11) System.out.println("Bingo \"else if\" x = 11");
            else System.out.println("\"else\" x = " + x);
        }
    }
}
