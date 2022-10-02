package java_fundamentals.task4;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static int maxInt = 500;
    public static void main(String[] args) {
        int n = 10;

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = ThreadLocalRandom.current().nextInt(0, maxInt);
            System.out.printf("%d ", values[i]);
        }
        System.out.println("\nIndexes of prime numbers in array: ");

        findPrimeNumberInArray(values);
    }

    static void findPrimeNumberInArray(int[] values) {

        int size = values.length;
        boolean isPrimeNumbers = false;
        for (int i = 0; i < size; i++) {
            if (isPrime(values[i])) {
                System.out.printf("%d ", i);
                isPrimeNumbers = true;
            }
        }
        if (!isPrimeNumbers) {
            System.out.println("no prime numbers");
        }
    }

    static boolean isPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
