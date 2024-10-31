import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
import java.lang.Math;
// reference: https://www.coursera.org/learn/algorithms-part1/
// "The generation fo random numbers is too important to be left to chance" - Robert R. Coveyou
public class KnuthShuffle {
    public static void sort (int[] a) {
        // Shuffle must be uniform btw 1st to i element
        // ideally, random must be at least 2^(a.length = N)
        // seed is not just milliseconds starting from midnight
        for (int i = 0; i < a.length; i++) {
            int r = StdRandom.uniformInt(i + 1);
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
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
        KnuthShuffle.sort(cards);
        System.out.println("Cards: ");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + ", ");
        }
        System.out.println("---");
    }
}
