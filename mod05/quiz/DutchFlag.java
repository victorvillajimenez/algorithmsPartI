/*
Module 5 - Interview Questions: Elementary Sorts

3.- Dutch national flag. Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color.
    The allowed operations are:
    - swap(i, j): swap the pebble in bucket i with the pebble in bucket j.
    - color(i): determine the color of the pebble in bucket i.
The performance requirements are as follow:
- At most n calls to color().
- At most n calls to swap().
- Constant extra space.

HINT: 3-way partitioning.
*/
public class DutchFlag {
    private String[] a; // values in a => red, white or blue
    public void treeWayPartition () {
        int i = 0;
        int j = 0;
        int k = a.length - 1;
        while (j <= k) {
            String jColor = color(j);
            if (jColor.equals("red")) {
                swap(i, j);
                i++;
                j++
            } else if (jColor.equals("blue")) {
                swap(j, k);
                k--;
            } else {
                j++;
            }
        }
    }
    public void swap (int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public String color (int i) {
        return a[i];
    }
    public void generateRandomColors () {
        this.a = new String[10];
        this.a[0] = "blue";
        this.a[1] = "red";
        this.a[2] = "blue";
        this.a[3] = "white";
        this.a[4] = "red";
        this.a[5] = "blue";
        this.a[6] = "red";
        this.a[7] = "red";
        this.a[8] = "red";
        this.a[9] = "white";
    }
    public static void main (String[] args) {
        DutchFlag dutchFlag = new DutchFlag();
        dutchFlag.generateRandomColors();
        dutchFlag.treeWayPartition();
    }
}