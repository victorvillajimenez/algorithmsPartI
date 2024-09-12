public abstract class UnionFind {
    protected int[] a;

    public UnionFind (int n) {
        this.a = new int[n];
        for (int i = 0; i < n; i++) this.a[i] = i;
    }

    public abstract boolean connected(int p, int q);

    public abstract void union(int p, int q);

    public void showData () {
        System.out.println("");
        System.out.println("[ ");
        for (int i = 0; i < this.a.length; i++) {
            System.out.print(this.a[i] + ", ");
        }
        System.out.println(" ]");
    }
}