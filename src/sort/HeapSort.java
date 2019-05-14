package sort;

import utils.Util;

public class HeapSort {
    public static void heatSort(int[] array) {
        adjustHeap(array, array.length);
        for (int i = array.length - 1; i > 0; i--) {
            Util.swap(array, 0, i);
            adjustHeap(array, i);
        }
    }

    public static void adjustHeap(int[] array, int len) {
        int i = len - 1;
        while(i >= 0) {
            if ((i - 1)/2 >=0 && array[(i-1)/2] < array[i]) {
                Util.swap(array, i, (i-1)/2);
            }
            if ((i - 2)/2 >=0 && array[(i-2)/2] < array[i]) {
                Util.swap(array, i, (i-2)/2);
            }
            i--;
        }
    }
}
