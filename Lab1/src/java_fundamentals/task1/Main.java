package java_fundamentals.task1;

public class Main {
    public static void main(String[] args) {
        double x = 3.0;
        double y = 12.0;
        System.out.println(calculateExpression(x, y));
    }

    static double calculateExpression(double x, double y) {
        double numerator = 1 + Math.pow(Math.sin(x + y), 2);
        double denominator = 2 + Math.abs(x - (2 * x) / (1 + Math.pow(x, 2) * Math.pow(y, 2)));
        return numerator / denominator + x;
    }
}
