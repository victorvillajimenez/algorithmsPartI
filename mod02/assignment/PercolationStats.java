import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
// import edu.princeton.cs.algs4.StdStats;
/**
 * reference: https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php
 */
public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;
    private double[] t;

    // Execute X Monte Carlo simulations or trials
    public PercolationStats (int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("Inputs must be greater than 0")
        this.t = new double[trials];
        Percolation percolation;
        Stopwatch stopwatch = new Stopwatch();
        for (int trial = 0; trial < trials; trial++) {
            percolation = new Percolation(n);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniformInt(n) + 1, StdRandom.uniformInt(n) + 1);
            }
            this.t[trial] = Double.valueOf(percolation.numberOfOpenSites()) / (n * n);
        }
        System.out.println("Time in seconds: " + stopwatch.elapsedTime());
    }

    public double mean () {
        // StdStats.mean(this.t);
        double sum = 0.0;
        for (double val : this.t) sum += val;
        return sum / this.t.length;
    }

    public double stddev () {
        // StdStats.stddev(this.t);
        double mean = this.mean();
        double sum = 0.0;
        for (double val : this.t) {
            double diff = val - mean;
            sum += (diff * diff);
        }
        return Math.sqrt(sum / (this.t.length - 1));
    }

    public double confidenceLo () {
        return this.mean() - (CONFIDENCE_95 * this.stddev()) / (Math.sqrt(this.t.length));
    }

    public double confidenceHi () {
        return this.mean() + (CONFIDENCE_95 * this.stddev()) / (Math.sqrt(this.t.length));
    }

    public static void main (String[] args) {
        if (args.length < 2)  {
            System.out.println("PercolationStats was not executed... missing two in args");
        } else {
            int n = Integer.parseInt(args[0]);
            int t = Integer.parseInt(args[1]);
            PercolationStats stats = new PercolationStats(n, t);
            System.out.println(String.format("%-24s= ", "mean") + stats.mean());
            System.out.println(String.format("%-24s= ", "stddev") + stats.stddev());
            System.out.println(String.format("%-24s= [", "95% confidence interval") + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
        }
    }
}
