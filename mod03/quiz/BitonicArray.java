/*
    Analysis of Algorithms
    2. Search in a bitonic array.
    An array is bitonic if it is comprised of an increasing sequence of integers
    followed immediately by a decreasing sequence of integers.
    Write a program that, given a bitonic array of N distinct integer values,
    determines whether a given integer is in the array.
    - Standard version: Use ∼3 lg N compares in the worst case.
    - Signing bonus: Use ∼2 lg N compares in the worst case (and prove that
      no algorithm can guarantee to perform fewer than ∼2 lg N compares in the worst case).

    Hints: Standard version. First, find the maximum integer using ∼1lgn 
    compares—this divides the array into the increasing and decreasing pieces.
    Signing bonus. Do it without finding the maximum integer.
*/
public class BitonicArray {

    public static void main (String[] args) {
        int[] a = new int[]{6,7,8,11,9,5,2,1};
        int[] b = new int[]{3,4,7,8,6,5,2,1};
        System.out.println("BitonicArray.search: " + BitonicArray.search(a, 2));
        System.out.println("BitonicArray.search: " + BitonicArray.search(b, 7));
    }

    public static int search (int[] a, int x) {
        int bitonicPoint = findBitonicPoint(a, 1, a.length - 2);
        if (bitonicPoint == -1) return -1;
        if (a[bitonicPoint] == x) return bitonicPoint;
        int i = binarySearch(a, 0, bitonicPoint - 1, true, x);
        if (i != -1) return i;
        return binarySearch(a, bitonicPoint + 1, a.length - 1, false, x);
    }

    private static int binarySearch (int[] a, int start, int end, boolean isAsc, int x) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == x) return mid;
            boolean expression = isAsc ? a[mid] < x : a[mid] > x;
            if (expression) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    private static int findBitonicPoint (int[] a, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) return mid;
            if (a[mid] < a[mid + 1]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
