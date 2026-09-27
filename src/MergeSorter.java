public class MergeSorter {
    private static final int CUTOFF = 16;
    public long comparisons = 0;
    public int maxDepth = 0;

    public void sort(int[] a) {
        if (a == null || a.length < 2) return;
        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length - 1, 1);
    }

    private void mergeSort(int[] a, int[] temp, int l, int r, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        if (r - l + 1 <= CUTOFF) {
            insertionSort(a, l, r);
            return;
        }

        int m = (l + r) / 2;
        mergeSort(a, temp, l, m, depth + 1);
        mergeSort(a, temp, m + 1, r, depth + 1);
        merge(a, temp, l, m, r);
    }

    private void merge(int[] a, int[] temp, int l, int m, int r) {
        for (int i = l; i <= r; i++) temp[i] = a[i];

        int i = l, j = m + 1, k = l;

        while (i <= m && j <= r) {
            comparisons++;
            a[k++] = temp[i] <= temp[j] ? temp[i++] : temp[j++];
        }

        while (i <= m) a[k++] = temp[i++];
        while (j <= r) a[k++] = temp[j++];
    }

    private void insertionSort(int[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int x = a[i], j = i - 1;

            while (j >= l && a[j] > x) {
                comparisons++;
                a[j + 1] = a[j--];
            }

            a[j + 1] = x;
        }
    }
}