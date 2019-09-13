package floating.point.issues;

public class FloatingPointIssues {
    static final double O_POINT_1 = 1.000001d;
    static final double O_POINT_3 = 179.355778;

    public static void main(String[] args) {

        System.out.println("0.1 in double representation is: " + O_POINT_1);
        System.out.println("0.3 in double representation is: " + O_POINT_3);
        System.out.println("0.1 + 0.3 in double representation is:" + (O_POINT_1 + O_POINT_3));
    }
}
