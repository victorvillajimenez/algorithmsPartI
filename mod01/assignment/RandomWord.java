import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main (String[] args) {
        int i = 1;
        String w = "";
        while (!StdIn.isEmpty()) {
            String t = StdIn.readString();
            if (StdRandom.bernoulli(1D / i++)) {
                w = t;
            }
        }
        StdOut.println(w);
    }
}
