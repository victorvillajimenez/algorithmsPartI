// import edu.princeton.cs.algs4.StdIn;

public class UFQuickUnionWithPathCompression extends UnionFind {

    public UFQuickUnionWithPathCompression (int n) {
        super(n);
    }
    public int find (int i) {
        int r = i;
        while (r != this.a[r]) {
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
        return find(p) == find(q);
    }
    public void union (int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (i < j) {
            this.a[i] = j;
        } else {
            this.a[j] = i;
        }
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        UFQuickUnionWithPathCompression qupc = new UFQuickUnionWithPathCompression(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!qupc.connected(p, q)) {
                qupc.union(p, q);
            }
        }
        qupc.showData();
    }
}
