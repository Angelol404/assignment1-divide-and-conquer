import java.util.Random;

public class QuickSorter {
    public long comparisons = 0;
    public int maxDepth = 0;

    private final Random random = new Random();

    public void sort(int[] a) {
        if (a == null || a.length < 2) return;
        quickSort(a, 0, a.length - 1, 1);
    }

    private void quickSort(int[] a, int l, int r, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        while (l < r) {
            int p = partition(a, l, r);

            if (p - l < r - p) {
                quickSort(a, l, p - 1, depth + 1);
                l = p + 1;
            } else {
                quickSort(a, p + 1, r, depth + 1);
                r = p - 1;
            }
        }
    }

    private int partition(int[] a, int l, int r) {
        int pivotIndex = l + random.nextInt(r - l + 1);
        swap(a, pivotIndex, r);

        int pivot = a[r];
        int i = l - 1;

        for (int j = l; j < r; j++) {
            comparisons++;

            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        swap(a, i + 1, r);
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}