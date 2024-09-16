/**
1. Social network connectivity. Given a social network containing n members and
a log file containing m timestamps at which times pairs of members formed friendships,
design an algorithm to determine the earliest time at which all members are connected
(i.e., every member is a friend of a friend of a friend ... of a friend).
Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
The running time of your algorithm should be m log n or better and use extra space proportional to n.

Hint: union−find.

All members will be connected when Union-Find has one connected component.
UFWQUPC = Union Find Weighted Quick Union With Path Compression
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class UFQuickUnionWeightedWithPathCompression {
    private int[] a;
    private int[] sz;
    private boolean areAllConnected;

    public UFQuickUnionWeightedWithPathCompression (int n) {
        this.a = new int[n];
        for (int i = 0; i < n; i++) this.a[i] = i;
        this.sz = new int[n];
        for (int i = 0; i < n; i++) this.a[i] = 1;
        this.areAllConnected = false;
    }

    public int root (int i) {
        while (i != this.a[i]) {
            this.a[i] = this.a[this.a[i]];
            i = this.a[i];
        }
        return i;
    }

    public boolean connected (int p, int q) {
        if (this.areAllConnected) return true;
        return root(p) == root(q);
    }

    public void union (int p, int q) {
        int j = root(p);
        int i = root(q);
        if (i == j) return;
        if (this.sz[i] < this.sz[j]) {
            this.a[i] = j;
            this.sz[j] += this.sz[i];
            if (this.sz[j] == this.a.length) this.areAllConnected = true;
        } else {
            this.a[j] = i;
            this.sz[i] += this.sz[j];
            if (this.sz[i] == this.a.length) this.areAllConnected = true;
        }
    }

    public boolean allMembersConnected () {
        return this.areAllConnected;
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        UFQuickUnionWeightedWithPathCompression ufwpc =
            new UFQuickUnionWeightedWithPathCompression(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!ufwpc.connected(p, q)) ufwpc.union(p, q);
            if (ufwpc.allMembersConnected()) StdOut.println("All members connected now!");
        }
    }
}
