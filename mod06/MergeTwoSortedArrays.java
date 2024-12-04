public class MergeTwoSortedArrays {
    private static boolean isSorted (Comparable[] a, int start, int end) {
        for (int i = start; i < end; i++) if (less(a[i + 1], a[i])) return false;
        return true;
    }
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    public static void merge (Comparable[] a, Comparable[] aux, int start, int mid, int end) {
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
}
