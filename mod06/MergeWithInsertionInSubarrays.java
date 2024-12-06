// Require extra space O(N)
// It is STABLE. It is important when an Object array is required to order by "name" first, then by "age"
// Note: Need to carefully check code ("less than" vs "less than or equal to")
// It should be Comparable[] instead, since mergesort is more useful for Objects,
// because it is a stable sorting
// Why insertion sort? and not Selectionsort or Shellsort?
// because Insertionsort and Mergesort are STABLE, so both preserve
// the relative order of items with equal keys
public class MergeWithInsertionInSubarrays {
    public static final int CUTOFF = 7;
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static boolean isSorted (Comparable[] a, int start, int end) {
        for (int i = start; i < end; i++) if (less(a[i + 1], a[i])) return false;
        return true;
    }
    private static void insertion (Comparable[] a, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = i; j > start; j--) {
                if (less(a[j], a[j - 1])) {
                    Comparable t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                } else break;
            }
        }
    }
    private static void sort (Comparable[] a, Comparable[] t, int start, int end) {
        // Coming soon
    }
    private static void merge (Comparable[] a, Comparable[] t, int start, int mid, int end) {
        // Coming soon
    }
    public static void perform (Comparable[] a) {
        Comparable[] t = new Comparable[a.length];
        sort(a, t, 0, a.length - 1);
    }
}
