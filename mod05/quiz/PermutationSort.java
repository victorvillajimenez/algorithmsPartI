/*
Module 5 - Interview Questions: Elementary Sorts

2.- Permutation. Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is a
permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.
HINT: Sort both arrarys.
*/
import java.util.Random;
public class PermutationSort {
    public static void shellsort (int[] a) {
        int h = 1;
        while (h < a.length / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    int tmp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = tmp;
                }
            }
            h /= 3;
        }
    }
    public static boolean sameContent (int[] a, int[] b) {
        if (a.length != b.length) return false;
        shellsort(a);
        shellsort(b);
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }
    public static void main (String[] args) {
        int[] a = generateRandomArray(100);
        int[] b = generateRandomArray(100);
        boolean res = sameContent(a, b);
        System.out.println(res ? "Same content" : "Differente content");
    }
    private static int[] generateRandomArray (int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) a[i] = i;
        shuffle(a);
        return a;
    }
    private static void shuffle (int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = random.nextInt(i + 1);
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    private static void printArray (int[] a) {
        System.out.println("print array: ");
        for (int v : a) System.out.print(i + ", ");
        System.out.println("-----");
    }
}
