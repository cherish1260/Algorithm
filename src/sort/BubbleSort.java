package sort;

/**
 * 冒泡排序：相邻的值两两比较，较大的放到后边这样，每次回将最大的放到正确的位置
 *  时间复杂度：O(n**2)
 *  稳定排序
 *  原地排序
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        // 数组长度
        int length = array.length;
        for (int i = 0; i < length; i++) {
            // 用于记录是否有交换操作
            boolean flag = false;
            for (int j = 0; j < length - i -1; j++) {
                // 如果前者小于后者，则交换位置，并设置flag为true
                if (array[j] > array[j + 1]) {
                    Util.swap(array, j, j+1);
                    flag = true;
                }
            }
            // 如果flag为false，说明没有进行交换，则可以不再继续
            if (flag == false) {
                break;
            }
        }
    }
}
