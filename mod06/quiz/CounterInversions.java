/*
Module 06 - Interview Questions: Mergesort

2. Counting inversions.
An inversion in an array a[] is a pair pf entries a[i] and a[j] such that i < j but a[i] > a[j].
Given an array, design a linearithmic algorithm to count the number of inversions.
*/
public class CounterInversions {
    public static int counter;
    public static void main (String[] args) {
        int[] a = new int[]{373, 910, 846, 436, 223, 655, 390, 811, 316, 124};
        int c = perform(a);
        System.out.println("Counter: " + c);
    }
    public static int perform (int[] a) {
        counter = 0;
        sort(a, 0, a.length - 1);
        return counter;
    }
    private static void sort (int[] a, int start, int end) {
        if (end <= start) return;
        int mid = start + (end - start) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);
        merge(a, start, mid, end);
    }
    private static void merge (int[] a, int start, int mid, int end) {
        int[] left = new int[mid - start - 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < left.length; i++) left[i] = a[i + start];
        for (int i = 0; i < right.length; i++) right[i] = a[i + mid + 1];
        int l = 0;
        int r = 0;
        int i = start;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                a[i++] = left[l++];
            } else {
                a[i++] = right[r++];
                counter += (mid + 1) - (start + l);
            }
        }
        while (l < left.length) a[i++] = left[l++];
        while (r < right.length) a[i++] = right[r++];
    }
}
