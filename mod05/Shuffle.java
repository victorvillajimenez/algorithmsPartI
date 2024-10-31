import java.lang.Math;
/**
 *  1. Generate a random real number for each array entry
 *  2. Sort the array
 */
public class Shuffle {
    private static void quicksort (int[] c, double[] a, int start, int end) {
        if (start < end) {
            int p = partition(c, a, start, end);
            quicksort(c, a, start, p - 1);
            quicksort(c, a, p + 1, end);
        }
    }

    private static int partition (int[] c, double[] a, int start, int end) {
        double pivot = a[end];
        int pivotCard = c[end];
        int j = start - 1;
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                double tmp = a[++j];
                a[j] = a[i];
                a[i] = tmp;
                int tmpCard = c[j];
                c[j] = c[i];
                c[i] = tmpCard;
            }
        }
        a[end] = a[++j];
        a[j] = pivot;
        c[end] = c[j];
        c[j] = pivotCard;
        return j;
    }

    public static void sort (int[] cards) {
        double[] nums = new double[cards.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.random();
        }
        quicksort(cards, nums, 0, nums.length - 1);
    }

    public static void main (String[] args) {
        int[] cards = new int[52];
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[(i * 13) + (j - 1)] = j + (i * 20);
            }
        }
        System.out.println("Cards: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + ", ");
        }
        System.out.println("---");
        Shuffle.sort(cards);
        System.out.println("Cards: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + ", ");
        }
        System.out.println("---");
    }
}