import java.util.Arrays;

public class DeterministicSelector {
    public long comparisons = 0;
    public int maxDepth = 0;

    public int select(int[] a, int k) {
        if (k < 0 || k >= a.length) throw new IllegalArgumentException();
        return select(a, 0, a.length - 1, k, 1);
    }

    private int select(int[] a, int l, int r, int k, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        if (l == r) return a[l];

        int pivot = medianOfMedians(a, l, r);
        int p = partition(a, l, r, pivot);

        if (k == p) return a[p];
        if (k < p) return select(a, l, p - 1, k, depth + 1);
        return select(a, p + 1, r, k, depth + 1);
    }

    private int medianOfMedians(int[] a, int l, int r) {
        int n = r - l + 1;

        if (n <= 5) {
            Arrays.sort(a, l, r + 1);
            return a[l + n / 2];
        }

        int groups = (n + 4) / 5;
        int[] medians = new int[groups];

        int index = 0;

        for (int i = l; i <= r; i += 5) {
            int end = Math.min(i + 4, r);

            Arrays.sort(a, i, end + 1);

            medians[index++] =
                    a[i + (end - i) / 2];
        }

        return select(
                medians,
                0,
                medians.length - 1,
                medians.length / 2,
                1
        );
    }

    private int partition(int[] a, int l, int r, int pivot) {
        int pivotIndex = l;

        for (int i = l; i <= r; i++) {
            comparisons++;

            if (a[i] == pivot) {
                pivotIndex = i;
                break;
            }
        }

        swap(a, pivotIndex, r);

        int p = l;

        for (int i = l; i < r; i++) {
            comparisons++;

            if (a[i] < pivot) {
                swap(a, i, p);
                p++;
            }
        }

        swap(a, p, r);
        return p;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}