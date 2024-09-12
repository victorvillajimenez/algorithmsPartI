import edu.princeton.cs.algs4.StdIn;
/*
initialize      union       find/connected
    N           log N*          log N
* includes cost of finding roots

find: takes time proportional to depth of p and q
Union: takes constant time, given roots

Depth of any node x is at most log N
*/
public class UFQuickUnionWeightedBySize extends UnionFind {
    private int[] sz;

    public UFQuickUnionWeightedBySize (int n) {
        super(n);
        this.sz = new int[n];
        for (int i = 0; i < n; i++) this.sz[i] = 1;
    }
    public int root (int i) {
        while (i != this.a[i]) i = this.a[i];
        return i;
    }
    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }
    public void union (int p, int q) {
        int idxP = root(p);
        int idxQ = root(q);
        if (idxP == idxQ) return;
        if (this.sz[idxP] < this.sz[idxQ]) {
            this.a[idxP] = idxQ;
            this.sz[idxQ] += this.sz[idxP];
        } else {
            this.a[idxQ] = idxP;
            this.sz[idxP] += this.sz[idxQ];
        }
    }

    public void showData () {
        System.out.println("");
        System.out.println("[ ");
        for (int i = 0; i < this.a.length; i++) {
            System.out.print(" [" + this.a[i] + "].size: " + this.sz[i] + ", ");
        }
        System.out.println(" ]");
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        UFQuickUnionWeightedBySize quws = new UFQuickUnionWeightedBySize(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!quws.connected(p, q))  {
                quws.union(p, q);
            }
        }
        quws.showData();
    }
}
