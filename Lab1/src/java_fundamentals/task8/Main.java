package java_fundamentals.task8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static double maxDouble = 50.0;
    public static void main(String[] args) {
        int n = 10;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = ThreadLocalRandom.current().nextDouble(0, maxDouble);
        }

        Arrays.sort(a);
        System.out.print("a array:");
        for (double val: a) {
            System.out.printf("%6.2f", val);
        }

        int m = 10;
        double[] b = new double[m];

        for (int i = 0; i < m; i++) {
            b[i] = ThreadLocalRandom.current().nextDouble(0, maxDouble);
        }

        Arrays.sort(b);
        System.out.print("\nb array:");
        for (double val: b) {
            System.out.printf("%6.2f", val);
        }

        System.out.println("");
        findPlaceToInsert(n, a, m, b);
    }

    private static void findPlaceToInsert(int n, double[] a, int m, double[] b) {
        int i = 0;
        for (int j = 0; j < m; j++) {
            if ((i == 0) && (b[j] <= a[i])) {
                System.out.printf("Element b%d should be insert before a0 \n", j + 1);
            } else {
                while ((i + 1 < n) && !((a[i] <= b[j]) && (b[j] <= a[i + 1]))) {
                    i++;
                }
                System.out.printf("Element b%d should be insert after a%d \n", j + 1, i + 1);
            }
        }
    }
}
