package sort;

import utils.Util;

import java.util.ArrayList;

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

    public static void heatSort2(int[] array) {
        for (int i = array.length/2 - 1; i >= 0; i--) {
            justifyHeap(array, i, array.length);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = array.length - 1; j >= 0; j--) {
            Util.swap(array, 0, j);
            list.add(array[j]);
            justifyHeap(array, 0, j - 1);
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

    public static void justifyHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k + 1 < length && arr[k] > arr[k+1]){//如果左子结点大于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] < temp){//如果子节点小于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }
}
