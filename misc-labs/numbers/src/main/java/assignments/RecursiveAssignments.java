package assignments;

public class RecursiveAssignments {

    public static void main(String[] args) {
        int x = 10;
        x = x++;
        System.out.println("x = x++ : " + x); // 10

        x = 10;
        x += x++;
        System.out.println("x += x++ : " + x); // 20

        x = 10;
        x = x + x++;
        System.out.println("x = x + x++ : " + x); // 20

        x = 10;
        x = x++ + x;
        System.out.println("x = x++ + x : " + x); // 21

        x = 10;
        x += ++x;
        System.out.println("x += ++x : " + x); //21

        x = 10;
        x = ++x + x;
        System.out.println("x = ++x + x: " + x); // 22

    }
}
