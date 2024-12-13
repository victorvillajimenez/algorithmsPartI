/**
 * Goal: Given an array of N items, find the kth smallest item.
 * Examples: Min (k = 0), Max (k = n - 1), Median (k = n / 2)
 * Remark: it takes linear time on average. It uses N^2 / 2 compares in the worst case, but
 *         (as with quicksort) the random shuffle provides a probabilistic guarantee.
 */
public class QuickSelect {
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static void swap (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static int partition (Comparable[] a, int start, int end) {
        // Coming soon
    }
    public static void main (String[] args) {
        Integer[] a = {87,9,7,23,666,999,3,1,6,125,3,2,6,709,32,8,9,2,159,212,91,3,0,555};
        int k = 11; // start from index 0
        Comparable topK = perform(a, k);
        System.out.println("Smallest kth: " + topK.toString()); // Expected value: 9
    }
    public static Comparable perform (Comparable[] a, int k) {
        // Coming soon
    }
}
