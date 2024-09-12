import edu.princeton.cs.algs4.StdIn;
/*
Quick-find is eager approach

initialize      union       find/connected
    N             N               1

union is too expensive and slow,
N^2 array accesses to process a sequence of N union commands on N objects
*/
public class UFQuickFind extends UnionFind {

    public UFQuickFind (int n) {
        super(n);
    }
    public boolean connected (int p, int q) {
        return this.a[p] == this.a[q];
    }
    public void union (int p, int q) {
        int idxP = this.a[p];
        int idxQ = this.a[q];
        for (int i = 0; i < this.a.length; i++) {
            if (this.a[i] == idxP) this.a[i] = idxQ;
        }
    }

    public static void main (String[] args) {
        int n = StdIn.readInt();
        UFQuickFind quickFind = new UFQuickFind(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!quickFind.connected(p, q)) {
                quickFind.union(p, q);
            }
        }
        quickFind.showData();
    }
}
