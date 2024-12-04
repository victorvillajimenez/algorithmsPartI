// Require extra space O(N)
// It is STABLE. It is important when an Object array is required to order by "name" first, then by "age"
// Note: Need to carefully check code ("less than" vs "less than or equal to")
// It should be Comparable[] instead, since mergesort is more useful for Objects,
// because it is a stable sorting
public class Merge {
    private static boolean isSorted (Comparable[] a, int start, int end) {
        for (int i = start; i < end; i++) if (less(a[i + 1], a[i])) return false;
        return true;
    }
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static void merge (Comparable[] a, Comparable[] aux, int start, int mid, int end) {
        assert isSorted(a, start, mid);
        assert isSorted(a, mid + 1, end);
        for (int i = start; i <= end; i++) aux[i] = a[i];
        int i = start;
        int j = mid + 1;
        for (int k = start; k <= end; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > end) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        } 
        assert isSorted(a, start, end);
    }
    private static void sort (Comparable[] a, Comparable[] aux, int start, int end) {
        if (end <= start) return;
        int mid = start + (end - start) / 2;
        sort(a, aux, start, mid);
        sort(a, aux, mid + 1, end);
        merge(a, aux, start, mid, end);
    }
    public static void perform (Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
