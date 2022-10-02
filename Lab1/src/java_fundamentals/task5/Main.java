package java_fundamentals.task5;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static int maxInt = 50;
    public static void main(String[] args) {
        int n = 5;

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = ThreadLocalRandom.current().nextInt(0, maxInt);
            System.out.printf("%d ", values[i]);
        }

        int K = getAmountOfDeletedElements(values);
        System.out.printf("\nThe minimum of elements should be deleted: %d", K);
    }

    static int getAmountOfDeletedElements(int[] values) {
        int size = values.length;
        int maxLength = 1;
        int currLength = 1;
        int prevEl = values[0];
        for (int i = 1; i < size; i++) {
            if (values[i] > prevEl) {
                currLength++;
            } else {
                if (currLength > maxLength) {
                    maxLength = currLength;
                }
                currLength = 1;
            }
            if (currLength > maxLength) {
                maxLength = currLength;
            }
            prevEl = values[i];
        }
        return values.length - maxLength;
    }
}
