import java.util.*;

public class AlgorithmTests {

    public static void main(String[] args) {

        testMergeSort();
        testQuickSort();
        testSelect();
        testClosestPair();

        System.out.println("All tests passed!");
    }

    private static void testMergeSort() {

        int[] a = {5, 2, 8, 1, 3};
        int[] expected = a.clone();

        Arrays.sort(expected);

        MergeSorter sort = new MergeSorter();
        sort.sort(a);

        if (!Arrays.equals(a, expected))
            throw new RuntimeException("MergeSort failed");

        System.out.println("MergeSort test passed");
    }

    private static void testQuickSort() {

        int[] a = {9, 4, 6, 2, 8, 1};
        int[] expected = a.clone();

        Arrays.sort(expected);

        QuickSorter sort = new QuickSorter();
        sort.sort(a);

        if (!Arrays.equals(a, expected))
            throw new RuntimeException("QuickSort failed");

        System.out.println("QuickSort test passed");
    }

    private static void testSelect() {

        Random random = new Random();

        for (int t = 0; t < 100; t++) {

            int[] a = new int[50];

            for (int i = 0; i < a.length; i++)
                a[i] = random.nextInt(1000);

            int[] sorted = a.clone();
            Arrays.sort(sorted);

            int k = random.nextInt(a.length);

            DeterministicSelector selector =
                    new DeterministicSelector();

            int result =
                    selector.select(a.clone(), k);

            if (result != sorted[k])
                throw new RuntimeException(
                        "Deterministic Select failed"
                );
        }

        System.out.println(
                "Deterministic Select: 100 tests passed"
        );
    }

    private static void testClosestPair() {

        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        ClosestPairSolver solver =
                new ClosestPairSolver();

        double fast =
                solver.findClosest(points.clone());

        double brute =
                bruteForce(points);

        if (Math.abs(fast - brute) > 0.000001)
            throw new RuntimeException(
                    "Closest Pair failed"
            );

        System.out.println(
                "Closest Pair test passed"
        );
    }

    private static double bruteForce(Point[] p) {

        double min = Double.MAX_VALUE;

        for (int i = 0; i < p.length; i++) {

            for (int j = i + 1; j < p.length; j++) {

                min = Math.min(
                        min,
                        p[i].distance(p[j])
                );
            }
        }

        return min;
    }
}