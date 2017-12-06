package cc.ldy.practice;

/**
 * Created by ldy on 2017/12/5.
 */
public class QuickSort {
    public static void quicksort(int[] a) {
        partition(a, 0, a.length - 1);
    }

    public static void partition(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = a[start];
        int i = start + 1;
        int j = end;

        while (j > i) {
            while (a[i] <= pivot && i < end) i++;
            while (a[j] > pivot && j > start + 1) j--;

            if (i < j) {
                swap(a, i, j);
            }
        }

        if (i == j && j == start + 1 && a[j] > pivot) {
            j = start;
        } else {
            swap(a,start,j);
        }

        partition(a, start, j - 1);
        partition(a, j + 1, end);
    }

    private static void swap(int []a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
