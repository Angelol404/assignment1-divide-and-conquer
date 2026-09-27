import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] a1 = {8, 3, 5, 1, 9, 2};
        MergeSorter merge = new MergeSorter();
        merge.sort(a1);
        System.out.println("MergeSort: " + Arrays.toString(a1));

        int[] a2 = {10, 7, 8, 9, 1, 5};
        QuickSorter quick = new QuickSorter();
        quick.sort(a2);
        System.out.println("QuickSort: " + Arrays.toString(a2));

        int[] a3 = {12, 3, 5, 7, 4, 19, 26};
        DeterministicSelector select = new DeterministicSelector();
        System.out.println("k-th element: " + select.select(a3, 3));

        Point[] points = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)
        };

        ClosestPairSolver solver = new ClosestPairSolver();
        System.out.println("Closest distance: " + solver.findClosest(points));
    }
}