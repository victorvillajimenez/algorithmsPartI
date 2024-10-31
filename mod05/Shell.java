import java.lang.Comparable;
/*
  By Donald L. Shell
  Insertion with increment or decrement leaps/loops
  Improvement for Insertion sort
  It is an in-place comparison sort.
  Improvement of direct inserction

  Worst complexity: Depends on gap sequence
  Average complexity: n*log(n)^2 or n^(3/2)
  Best complexity: n
  Method: Insertion
  Stable: No
  Class: Comparison sort
*/
public class Shell {
    public static void sort (Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; // so far, the most appropiate increment sequence
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
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
