import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Experiment {

    public static void main(String[] args) throws IOException {

        FileWriter file = new FileWriter("results/results.csv");

        file.write("Algorithm,Type,Size,Time,Depth,Comparisons\n");

        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {

            testSorts(randomArray(size), "Random", file);
            testSorts(sortedArray(size), "Sorted", file);
            testSorts(reverseArray(size), "Reverse", file);
            testSorts(duplicateArray(size), "Duplicate", file);

            testSelect(size, file);
            testClosest(size, file);
        }

        file.close();

        System.out.println("Experiments finished.");
        System.out.println("results.csv updated.");
    }

    private static void testSorts(
            int[] a,
            String type,
            FileWriter file) throws IOException {

        int[] m = a.clone();
        MergeSorter merge = new MergeSorter();

        long start = System.nanoTime();
        merge.sort(m);
        long time = System.nanoTime() - start;

        file.write("MergeSort," + type + "," + a.length + ","
                + time + "," + merge.maxDepth + ","
                + merge.comparisons + "\n");


        int[] q = a.clone();
        QuickSorter quick = new QuickSorter();

        start = System.nanoTime();
        quick.sort(q);
        time = System.nanoTime() - start;

        file.write("QuickSort," + type + "," + a.length + ","
                + time + "," + quick.maxDepth + ","
                + quick.comparisons + "\n");
    }

    private static void testSelect(
            int size,
            FileWriter file) throws IOException {

        int[] a = randomArray(size);

        DeterministicSelector select =
                new DeterministicSelector();

        long start = System.nanoTime();

        select.select(a, size / 2);

        long time = System.nanoTime() - start;

        file.write("DeterministicSelect,Random," + size + ","
                + time + "," + select.maxDepth + ","
                + select.comparisons + "\n");
    }

    private static void testClosest(
            int size,
            FileWriter file) throws IOException {

        Point[] points = new Point[size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            points[i] = new Point(
                    r.nextDouble() * size,
                    r.nextDouble() * size
            );
        }

        ClosestPairSolver solver =
                new ClosestPairSolver();

        long start = System.nanoTime();

        solver.findClosest(points);

        long time = System.nanoTime() - start;

        file.write("ClosestPair,Random," + size + ","
                + time + "," + solver.maxDepth + ","
                + solver.comparisons + "\n");
    }

    private static int[] randomArray(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(n);

        return a;
    }

    private static int[] sortedArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = i;

        return a;
    }

    private static int[] reverseArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = n - i;

        return a;
    }

    private static int[] duplicateArray(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(5);

        return a;
    }
}