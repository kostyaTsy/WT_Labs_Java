package java_fundamentals.task3;

public class Main {

    public static void main(String[] args) {
        double fValue = 2;
        double sValue = 4;
        double step = 0.1;

        calculateTg(fValue, sValue, step);
    }

    static void calculateTg(double a, double b, double h) {
        double x = a;
        while (x <= b) {
            double f = Math.tan(x);
            System.out.printf("x: %f, f: %f \n", x, f);
            x += h;
        }
    }
}
