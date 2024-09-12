import edu.priceton.cs.algs4.StdIn;
/*
Quick-union is a lazy approach

initialize      union       find/connected
    N            N *               N

* includes cost of finding roots
Issues: Trees can get tall, find/connected too expensive
*/
public class UFQuickUnion extends UnionFind {

    public UFQuickUnion (int n) {
        super(n);
    }
    private int root (int i) {
        while (i != this.a[i]) i = this.a[i];
        return i;
    }
    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }
    public void union (int p, int q) {
        int idxP = root(p);
        int idxQ = root(q);
        this.a[idxP] = idxQ;
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        UFQuickUnion quickUnion = new UFQuickUnion(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!quickUnion.connected(p, q)) {
                quickUnion.union(p, q);
            }
        }
        quickUnion.showData();
    }
}
