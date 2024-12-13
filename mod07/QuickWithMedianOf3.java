/**
 * It is called "partition-exchange sort"
 * It is "divide and conquer" algorithm (based on multi-branched recursion)
 * 
 * Pick a random element and partition the array, such that all numbers that are less than it come before all elements
 * that are greater than it. Then do that for each half, then each quarter, etc. O(n log n) expected, O(n^2) worst case.
 * 
 * Inventor: Sir Charles Antony Richard Hoare (Tony Hoare) - 1960
 * Remark: n log n proababilistic guarantee, fastest in practice
 * Worst complexity: n^2 or n^2 / 2
 * Average complexity: n log n or 2 n log n
 * Best complexity: n log n
 * Space complexity: log n
 * Method: partitioning
 * Stable: No
 * In-place: Yes
 * Class: Comparison sort
 * 
 * Median of sample:
 * - Best choice of pivot item = median
 * - Estimate true median by taking median of sample
 * - Median-of-3 (random) items
 */
public class QuickWithMedianOf3 {
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
    private static int partition (Comparable[] a, int start, int end) {
        // Coming soon
    }
    private static int medianOf3 (Comparable[] a, int x, int y, int z) {
        // Coming soon
    }
    public static void main (String[] args) {
        Integer[] a = {87,9,7,23,666,999,3,1,6,125,3,2,6,709,32,8,9,2,159,212,91,3,0,555};
        // shuffle needed for performance guarantee
        // StdRandom.shuffle(a);
        perform(a);
    }
    public static void perform (Comparable[] a) {
        sort(a, 0, a.length - 1);
    }
}
