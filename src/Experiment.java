import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Experiment {

    public static void main(String[] args) throws IOException {

        FileWriter file = new FileWriter("results.csv");

        file.write("Algorithm,Type,Size,Time,Depth,Comparisons\n");

        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {

            testMerge(randomArray(size), "Random", file);
            testMerge(sortedArray(size), "Sorted", file);
            testMerge(reverseArray(size), "Reverse", file);

            testQuick(randomArray(size), "Random", file);
            testQuick(sortedArray(size), "Sorted", file);
            testQuick(reverseArray(size), "Reverse", file);
        }

        file.close();

        System.out.println("Experiments finished.");
        System.out.println("results.csv created.");
    }

    private static void testMerge(
            int[] a,
            String type,
            FileWriter file) throws IOException {

        MergeSorter sort = new MergeSorter();

        long start = System.nanoTime();
        sort.sort(a);
        long time = System.nanoTime() - start;

        file.write(
                "MergeSort," +
                        type + "," +
                        a.length + "," +
                        time + "," +
                        sort.maxDepth + "," +
                        sort.comparisons + "\n"
        );
    }

    private static void testQuick(
            int[] a,
            String type,
            FileWriter file) throws IOException {

        QuickSorter sort = new QuickSorter();

        long start = System.nanoTime();
        sort.sort(a);
        long time = System.nanoTime() - start;

        file.write(
                "QuickSort," +
                        type + "," +
                        a.length + "," +
                        time + "," +
                        sort.maxDepth + "," +
                        sort.comparisons + "\n"
        );
    }

    private static int[] randomArray(int n) {

        Random random = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = random.nextInt(n);

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
}