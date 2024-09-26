import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * reference: https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php
 */
public class Permutation {
    public static void main (String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String token = StdIn.readString();
            queue.enqueue(token);
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.dequeue());
        }
    }
}