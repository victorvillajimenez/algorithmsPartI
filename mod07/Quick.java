/**
 * It is called "partition-exchange sort"
 * It is "divide and conquer" algorithm (based on multi-branched recursion)
 * 
 * Pick a random element and partition the array, such that all numbers that are less than it come before all elements
 * that are greater than it. Then do that for each half, then each quarter, etc. O(n log n) expected, O(n^2) worst case.
 * 
 * Inventor: Sir Charles Antony Richard Hoare (Tony Hoare) - 1960
 * Remark: n log n probabilistic guarantee, fastest in practice
 * Worst complexity: n^2 or n^2 / 2
 * Average complexity: n log n or 2 n log n
 * Best complexity: n log n
 * Space complexity: log n
 * Method: partitioning
 * Stable: No
 * In-place: Yes
 * Class: Comparison sort
 */
public class Quick {
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static void swap (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static int partition (Comparable[] a, int start, int end) {
        int i = start;
        int j = end + 1;
        while (true) {
            // find item on left to swap
            while (less(a[++i], a[start])) if (i == end) break;
            // find item on right to swap
            while (less(a[start], a[--j])) if (j == start) break;
            if (i >= j) break; // check if pointers cross
            swap(a, i, j);
        }
        swap(a, start, j); // swap with partitioning item
        return j; // return index of item now known to be in place
    }
    private static void sort (Comparable[] a, int start, int end) {
        if (end <= start) return;
        int p = partition(a, start, end);
        sort(a, start, p - 1);
        sort(a, p + 1, end);
    }
    public static void perform (Comparable[] a) {
        // shuffle needed for performance guarantee
        // StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
}
