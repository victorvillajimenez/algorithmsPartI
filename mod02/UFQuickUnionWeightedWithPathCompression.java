// import edu.princeton.cs.algs4.StdIn;
/*
Initialize        Union       find/connected
    N             
*/
public class UFQuickUnionWeightedWithPathCompression extends UnionFind {
    private int[] sz;

    public UFQuickUnionWeightedWithPathCompression (int n) {
        super(n);
        this.sz = new int[n];
        for (int i = 0; i < n; i++) this.sz[i] = 1;
    }
    public int root (int i) {
        int r = i;
        while (r != this.a[r]) {
            // this.a[r] = this.a[this.a[r]];
            r = this.a[r];
        }
        while (r != this.a[i]) {
            int t = this.a[i];
            this.a[i] = r;
            i = t;
        }
        return r;
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
            System.out.print(" [" + this.a[i] + "].size: " + this.sz[i] + "], ");
        }
        System.out.println(" ]");
    }

    public static void main (String[] args) {
        // int n = StdIn.readInt();
        UFQuickUnionWeightedWithPathCompression quwpc =
            new UFQuickUnionWeightedWithPathCompression(10);
        // while (!StdIn.isEmpty()) {
        //     int p = StdIn.readInt();
        //     int q = StdIn.readInt();
        //     if (!quwpc.connected(p, q)) {
        //         quwpc.union(p, q);
        //     }
        // }
        quwpc.showData();
    }
}
