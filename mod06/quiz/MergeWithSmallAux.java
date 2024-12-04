/*
Module 06 - Interview Questions: Mergesort

1.- Merging with smaller auxiliary array.
Suppose that the subarray a[0] to a[n - 1] is sorted and the subarray a[n] to a[2 * n - 1] is sorted.
How can you merge the two arrays so that a[0] to a[2 * n - 1] is sorted using an auxiliary
of length n (instead of 2n) ?
HINT: copy only the left half into the auxiliary array.
*/
public class MergeWithSmallAux {
    public static void main (String[] args) {
        int[] a = new int[200];
        int mid = a.length / 2;
        for (int i = 0; i < mid; i++) {
            a[i] = i + i; // Fisrt half sorted with even numbers from 0 to 198
            a[i + 100] =  i + i + 1; // Second half sorted with odd numbers from 1 to 199
        }
        int[] t = new int[mid]; // Auxiliary of length n (instead of 2n)
        merge(a, t, 0, mid - 1, a.length - 1);
    }
    private static void merge (int[] a, int[] t, int start, int mid, int end) {
        // copy first half to auxiliary array t
        for (int i = start; i <= mid; i++) t[i] = a[i];
        int l = start;
        int r = mid + 1;
        for (int i = start; i <= end; i++) {
            if (l > mid) a[i] = a[r++];
            else if (r > end) a[i] = t[l++];
            else if (less(a[r], t[l])) a[i] = a[r++];
            else a[i] = t[l++];
        }
        assert isSorted(a, start, end);
    }
    private static boolean less (int a, int b) {
        return a < b;
    }
    private static boolean isSorted (int[] a, int start, int end) {
        for (int i = start; i < end; i++) if (less(a[i + 1], a[i])) return false;
        return true;
    }
}
