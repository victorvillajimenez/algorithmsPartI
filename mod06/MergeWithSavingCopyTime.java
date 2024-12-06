// Require extra space O(N)
// It is STABLE. It is important when an Object array is required to order by "name" first, then by "age"
// Note: Need to carefully check code ("less than" vs "less than or equal to")
// It should be Comparable[] instead, since mergesort is more useful for Objects,
// because it is a stable sorting
public class MergeWithSavingCopyTime {
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    // t must be set with values from a
    private static void sort (Comparable[] a, Comparable[] t, int start, int end) {
        // Coming soon
    }
    private static void merge (Comparable[] a, Comparable[] t, int start, int mid, int end) {
        // Coming soon
    }
    public static void perform (Comparable[] a) {
        Comparable[] t = new Comparable[a.length];
        // It is needed to make a copy from the beginning
        for (int i = 0; i < a.length; i++) t[i] = a[i];
        sort(t, a, 0, a.length - 1);
    }
}