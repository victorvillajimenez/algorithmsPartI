/**
 * Programming assigment 3: Collinear Points - Mergesort
 * https://coursera.cs.princeton.edu/algs4/assignments/collinear/specification.php
 * collinear.zip that contains Point.java, BruteCollinearPoints.java and FastCollinearPoints.java
 */
import java.util.List;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
public class BruteCollinearPoints {
    private LineSegment[] segments;
    public BruteCollinearPoints (Point[] points) {
        if (points == null) throw new IllegalArgumentException("Array is null");
        for (Point p : points) if (p == null) throw new IllegalArgumentException("An element in the array is null");
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Points duplicated");
                }
            }
        }
        List<LineSegment> lineSegments = new ArrayList<LineSegment>();
        for (int i = 0; i < points.length - 3; i++) {
            List<Point> seq = new ArrayList<>();
            for (int j = 0; j < points.length - 2; j++) {
                if (i == j) continue;
                double slopeToJ = points[i].slopeTo(points[j]);
                for (int k = 0; k < points.length - 1; k++) {
                    seq = new ArrayList<>();
                    if (i == k || j == k) continue;
                    double slopeToK = points[i].slopeTo(points[k]);
                    if (slopeToJ != slopeToK) continue;
                    for (int m = 0; m < points.length; m++) {
                        if (i == m || j == m || k == m) continue;
                        double slopeToM = points[i].slopeTo(points[m]);
                        if (slopeToK != slopeToM) continue;
                        if (seq.isEmpty()) {
                            seq.add(points[j]);
                            seq.add(points[k]);
                        }
                        seq.add(points[m]);
                    }
                    if (seq.isEmpty()) continue;
                    Point p = points[i];
                    Point q = points[i];
                    for (Point v : seq) {
                        if (p.compareTo(v) > 0) p = v;
                        if (q.compareTo(v) < 0) q = v;
                    }
                    LineSegment candidate = new LineSegment(p, q);
                    boolean isNew = true;
                    for (LineSegment seg : lineSegments) {
                        if (seg.toString().equals(candidate.toString())) {
                            isNew = false;
                            break;
                        }
                    }
                    if (isNew) lineSegments.add(candidate);
                }
            }
        }
        this.segments = new LineSegment[lineSegments.size()];
        this.segments = lineSegments.toArray(this.segments);
    }
    public int numberOfSegments () {
        return this.segments.length;
    }
    public LineSegment[] segments () {
        LineSegment[] copy = new LineSegment[segments.length];
        for (int j = 0; j < this.segments.length; j++) copy[j] = this.segments[j];
        return copy;
    }
    public static void main (String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[100];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(in.readInt(), in.readInt());
        }
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) p.draw();
        StdDraw.show();
        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment s : collinear.segments()) {
            StdOut.println(s);
            s.draw();
        }
        StdDraw.show();
    }
}
