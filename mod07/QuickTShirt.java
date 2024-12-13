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
public class QuickTShirt {
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void quicksort (Comparable[] a, int left, int right) {
        Comparable y;
        int i = left;
        int j = right;
        Comparable x = a[(left + right) / 2];
        do {
            while (less(a[i], x) && (i < right)) i++;
            while (less(x, a[j]) && (j > left)) j--;
            if (i <= j) {
                y = a[i];
                a[i++] = a[j];
                a[j--] = y;
            }
        } while (i <= j);
        if (left < j) quicksort(a, left, j);
        if (i < right) quicksort(a, i, right);
    }
}
