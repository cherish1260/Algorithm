package sort;

/**
 * 插入排序：将无序的数据插入到有序的数据中
 *  时间复杂度：O(n**2)
 *  稳定排序
 *  原地排序
 */
public class InsertSort {
    /**
     * 插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        // 数组长度
        int length = array.length;
        for (int i = 1; i < length; i++) {
            // 记录临时要插入的值
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 每次与有序数组中的末尾比较，小于则将该位置的值后移，直到大于退出
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 将要插入的值插入到正确的位置上
            array[j + 1] = temp;
        }
    }
}
