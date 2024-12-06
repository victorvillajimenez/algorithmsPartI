// Require extra space O(N)
// It is STABLE. It is important when an Object array is required to order by "name" first, then by "age"
// Note: Need to carefully check code ("less than" vs "less than or equal to")
// It should be Comparable[] instead, since mergesort is more useful for Objects,
// because it is a stable sorting
// Simple and Non-Recursive, BUT about 10% Slower
public class MergeBottomUp {
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static boolean isSorted (Comparable[] a, int start, int end) {
        for (int i = start; i < end; i++) if (less(a[i + 1], a[i])) return false;
        return true;
    }
    private static void sort (Comparable[] a) {
        // Coming soon
    }
    private static void merge (Comparable[] a, Comparable[] t, int start, int mid, int end) {
        // Coming soon
    }
    public static void peform (Comparable[] a) {
        sort(a);
    }
}