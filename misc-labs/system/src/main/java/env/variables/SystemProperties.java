package env.variables;

public class SystemProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
    }
}
