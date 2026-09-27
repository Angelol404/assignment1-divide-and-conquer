import java.util.*;

public class ClosestPairSolver {
    public int maxDepth = 0;
    public long comparisons = 0;

    public double findClosest(Point[] points) {
        Arrays.sort(points, Comparator.comparingDouble(p -> p.x));
        return closest(points, 0, points.length - 1, 1);
    }

    private double closest(Point[] p, int l, int r, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        if (r - l <= 3)
            return bruteForce(p, l, r);

        int mid = (l + r) / 2;
        double midX = p[mid].x;

        double left = closest(p, l, mid, depth + 1);
        double right = closest(p, mid + 1, r, depth + 1);

        double d = Math.min(left, right);

        List<Point> strip = new ArrayList<>();

        for (int i = l; i <= r; i++)
            if (Math.abs(p[i].x - midX) < d)
                strip.add(p[i]);

        strip.sort(Comparator.comparingDouble(a -> a.y));

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size()
                    && strip.get(j).y - strip.get(i).y < d; j++) {

                comparisons++;
                d = Math.min(d,
                        strip.get(i).distance(strip.get(j)));
            }
        }

        return d;
    }

    private double bruteForce(Point[] p, int l, int r) {
        double min = Double.MAX_VALUE;

        for (int i = l; i <= r; i++) {
            for (int j = i + 1; j <= r; j++) {
                comparisons++;
                min = Math.min(min, p[i].distance(p[j]));
            }
        }

        return min;
    }
}