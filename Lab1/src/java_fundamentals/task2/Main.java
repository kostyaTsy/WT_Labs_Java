package java_fundamentals.task2;

public class Main {
    public static void main(String[] args) {
        double x = 0;
        double y = 0;
        System.out.println(isValueInArea(x, y));
    }

    static boolean isValueInArea(double x, double y) {
        return ((x >= -4) && (x <= 4) && (y >= 0) && (y <= 5)) || ((x >= -6) && (x <= 6) && (y >= -3) && (y <= 0));
    }
}
