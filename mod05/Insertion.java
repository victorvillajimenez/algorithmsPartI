import java.lang.Comparable;
/*
  Array has two parts:
    Left side: including i, are in ascending order
    Right side: have not yet been seen

  Worst complexity: 1/2 n^2 compares and 1/2 n^2 exchanges (array is in opposite order)
  Average complexity: 1/4 n^2
  Best complexity: n - 1 compares and 0 exchanges (array is already sorted)
  Space complexity: 1
  Stable: YES. It is important when an Object array is required to order by "name" first, then by "age"
*/
public class Insertion {
    public static void sort (Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; i > 0; j--) {
                if (less(a[j], a[j - 1])) exch(a, j, j - 1);
                else break;
            }
        }
    }

    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted (Comparable[] a) {
        for (int i = 1; i < a.length; i++) if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
