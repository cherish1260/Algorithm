package sort;

import utils.Util;

/**
 * 堆排序
 */
public class HeapSort {
    public static void heatSort(int[] array) {
        adjustHeap(array, array.length);
        for (int i = array.length - 1; i > 0; i--) {
            Util.swap(array, 0, i);
            adjustHeap2(array, i);
        }
    }

    public static void adjustHeap(int[] array, int len) {
        int i = len - 1;
        while(i >= 0) {
            if ((i - 1)/2 >=0 && array[(i-1)/2] < array[i]) {
                Util.swap(array, i, (i-1)/2);
            }
            i--;
        }
    }

    public static void adjustHeap2(int[] array, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            int largeIndex = i;
            if (leftIndex < len && array[leftIndex] > array[i]) {
                largeIndex = leftIndex;
            }
            if (rightIndex < len && array[rightIndex] > array[largeIndex]) {
                largeIndex = rightIndex;
            }
            if (largeIndex != i) {
                Util.swap(array, largeIndex, i);
            }
        }
    }
}
