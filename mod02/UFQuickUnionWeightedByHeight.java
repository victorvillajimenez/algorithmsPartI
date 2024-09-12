import edu.princeton.cs.algs4.StdIn;
/*
Union-Find Quick Union Weighted By Height or Rank.
*/
public class UFQuickUnionWeightedByHeight extends UnionFind {
    private int[] h;

    public UFQuickUnionWeightedByHeight (int n) {
        super(n);
        this.h = new int[n];
        for (int i = 0; i < n; i++) this.h[i] = 0;
    }
    public int root (int i) {
        while (i != this.a[i]) i = this.a[i];
        return i;
    }
    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }
    public void union (int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (this.h[i] < this.h[j]) {
            this.a[i] = j;
        } else if (this.h[j] < this.h[i]) {
            this.a[j] = i;
        } else {
            this.a[i] = j;
            this.h[j]++;
        }
    }

    public void showData () {
        System.out.println("");
        System.out.println("[ ");
        for (int i = 0; i < this.a.length; i++) {
            System.out.print(" [" + this.a[i] + "].height: " + this.h[i] + ", ");
        }
        System.out.println(" ]");
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        UFQuickUnionWeightedByHeight quwh = new UFQuickUnionWeightedByHeight(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!quwh.connected(p, q)) {
                quwh.union(p, q);
            }
        }
        quwh.showData();
    }
}
