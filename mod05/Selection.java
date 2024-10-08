import java.lang.Comparable;
/*
  Array has two parts: 
    Left side: sorted sublist (by time will increase)
    Right side: unsorted sublist (by time will decrease)

  Find the smallest element using a linear scan and move it to the front. Then, find the second
  smallest and move it, again doing a linear scan. Continue doing this until all the elements
  are in place. O(n^2).
    
  Worst complexity: n^2
  Average complexity: n^2
  Best complexity: n^2
  Space complexity: 1
  Method: Selection (every iteration it finds the smallest in Rigth Side and swap it with the last Left Side)
  Stable: No
  Class: Comparison sort
  Worst case number of swaps: n - 1
*/
public class Selection {
    public static void sort (Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            if (min != i) exch(a, i, min);
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
