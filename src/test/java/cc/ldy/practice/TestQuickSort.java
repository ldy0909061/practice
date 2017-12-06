package cc.ldy.practice;

import org.junit.Test;

/**
 * Created by ldy on 2017/12/5.
 */
public class TestQuickSort {
    @Test
    public void test() throws Exception {
        int[] a = {3,10,3,7,4,5,8,9,11,3};
        QuickSort.quicksort(a);

        for (int v:a) {
            System.out.println(v);
        }
    }
}
