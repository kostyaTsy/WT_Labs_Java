package java_fundamentals.task7;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static double maxDouble = 50.0;
    public static void main(String[] args) {
        int n = 10;

        double[] values = new double[n];
        System.out.print("Initial array: ");
        for (int i = 0; i < values.length; i++) {
            values[i] = ThreadLocalRandom.current().nextDouble(0, maxDouble);
            System.out.printf("%.2f ", values[i]);
        }

        shellSort(values);

        System.out.print("\nThe sorted array: ");
        for (double value : values) {
            System.out.printf("%.2f ", value);
        }
    }

    private static void shellSort(double[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] <= arr[i + 1]) {
                i++;
            } else {
                double tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
                if (i > 0) {
                    i--;
                }
            }
        }
    }
}
