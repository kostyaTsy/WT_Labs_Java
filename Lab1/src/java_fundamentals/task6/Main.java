package java_fundamentals.task6;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static double maxDouble = 50.0;
    public static void main(String[] args) {
        int n = 5;
        double[] values = new double[n];

        System.out.print("Initial array: ");
        for (int i = 0; i < values.length; i++) {
            //values[i] = ThreadLocalRandom.current().nextInt(0, maxInt);
            values[i] = ThreadLocalRandom.current().nextDouble(0.0, maxDouble);
            System.out.printf("%.2f ", values[i]);
        }
        System.out.println("");

        double[][] matrix = generateMatrix(values);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    static double[][] generateMatrix(double[] values) {
        int size = values.length;
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = values[(j + i) % size];
            }
        }
        return matrix;
    }
}
