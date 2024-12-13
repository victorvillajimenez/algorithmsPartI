/**
 * 3-Way partitioning - For duplicate keys in array.
 * 
 * Goal: Partition array into 3 parts so that:
 * - Entries between lt and gt equal to partition item v.
 * - No larger entries to left of lt.
 * - No smaller entries to right of gt.
 * 
 * Dutch national flag problem - Edsger Dijkstra
 * 
 * Remark: improves quicksort in presence of duplicate keys
 * Worst complexity: n^2 / 2
 * Average complexity: 2 n log n
 * Best complexity: n
 * Space complexity: log n
 * Method: partitioning
 * Stable: No
 * In-place: Yes
 * Class: Comparison sort
 */
public class Quick3Way {
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static void swap (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void sort (Comparable[] a, int start, int end) {
        // Coming soon
    }
    public static void perform (Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
    public static void main (String[] args) {
        Comparable[] a = {87,9,7,23,666,999,3,1,6,125,3,2,6,709,32,8,9,2,159,212,91,3,0,555};
        // shuffle needed for performance guarantee
        // StdRandom.shuffle(a);
        perform(a);
    }
}
