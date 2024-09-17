/**
    Analysis of Algorithms
    1. 3-SUM in quadratic time.
    Design an algorithm for the 3-SUM problem that
    takes time proportional to N^2 in the worst case. You may assume that 
    you can sort the N integers in time proportional to N^2 or better.
    
    Count number of triplet sums in Array (3 sum)
    Elements MUST be DISTINCT

    Hint: given an integer x and a sorted array a[] of n distinct integers,
    design a linear-time algorithm to determine if there exists two distinct indices i and j
    such that a[i] + a[j] == x
 */
public class TripletSum {

    public static void main (String[] args) {
        int[] a = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println("TripletSum.count(a, 0) : " + TripletSum.count(a, 0));
        int[] b = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println("TripletSum.some(b, 0) : " + TripletSum.some(b, 0));
        int[] c = new int[]{30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println("TripletSum.someDeluxe(c, 0) : " + TripletSum.someDeluxe(c, 0));
    }

    public static int count (int[] a, int target) {
        quicksort(a);
        int count = 0;
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                int x = target - (a[i] + a[j]);
                int l = j + 1;
                int r = a.length - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (a[mid] > x) {
                        r = mid - 1;
                    } else if (a[mid] < x) {
                        l = mid + 1;
                    } else {
                        count++;
                        // If array has duplicates:
                        // int t = mid + 1;
                        // while (a[t] == a[mid] && t++ <= r && ) count++;
                        // t = mid - 1;
                        // while (a[t] == a[mid] && t-- >= l) count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    // Brute force, complexity O(N^3)
    public static boolean some (int[] a, int target) {
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; i < a.length - 1; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == target) return true;
                }
            }
        }
        return false;
    }

    // O(N^2)
    public static boolean someDeluxe (int[] a, int target) {
        quicksort(a);
        for (int i = 0; i < a.length - 2; i++) {
            int l = i + 1;
            int r = a.length - 1;
            while (l < r) {
                if (a[i] + a[l] + a[r] == target) return true;
                if (a[i] + a[l] + a[r] < target) l++;
                else r--;
            }
        }
        return false;
    }

    private static int partition (int[] a, int start, int end) {
        int pivot = a[end];
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (a[i] < pivot) {
                int t = a[++j];
                a[j] = a[i];
                a[i] = t;
            }
        }
        a[end] = a[++j];
        a[j] = pivot;
        return j;
    }

    private static void divide (int[] a, int start, int end) {
        if (end <= start) return;
        int p = partition(a, start, end);
        divide(a, start, p - 1);
        divide(a, p + 1, end);
    }

    private static void quicksort (int[] a) {
        divide(a, 0, a.length - 1);
    }
}