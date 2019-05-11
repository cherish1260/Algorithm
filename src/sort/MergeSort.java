package sort;

/**
 * 归并排序
 * 时间复杂度：O(nlog(n))
 * 稳定排序
 * 非原地排序
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param array
     * @param start
     * @param end
     */
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            // 找到中间点
            int mid = (start + end) / 2;
            // 对中间点左边的值进行排序
            mergeSort(array, start, mid);
            // 对中间点右边的值进行排序
            mergeSort(array, mid + 1, end);
            // 将左右两边排序后的值进行合并
            merge(array, start, mid, end);
        }
    }

    /**
     * 合并已经排好序的两部分
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] array, int start, int mid, int end) {
        // 新建一个临时数组
        int[] temp = new int[array.length];
        // 用于记录temp的赋值下标
        int i = start;
        // 分别记录左右两部分的起始点
        int left = start;
        int right = mid + 1;
        // 终止条件是其中一个数组完全合并
        while(left <= mid && right <= end) {
            // 左右相比，左小于右
            if (array[left] <= array[right]) {
                temp[i++] = array[left];
                left++;
            } else { // 右小于左
                temp[i++] = array[right];
                right++;
            }
        }
        // 左边数组未完全合并，则将剩余值赋值
        while(left <= mid) {
            temp[i++] = array[left];
            left++;
        }
        // 右边数组未完全合并，则将剩余值赋值
        while(right <= end) {
            temp[i++] = array[right];
            right++;
        }
        // 将临时数组的值赋值给原数组（更新排序后的值）
        for (int j = start; j <= end; j++) {
            array[j] = temp[j];
        }
    }
}
