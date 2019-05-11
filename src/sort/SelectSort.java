package sort;

/**
 * 选择排序：每次选取剩余最小的值放到正确的位置
 *  时间复杂度：O(n**2)
 *  非稳定排序
 *  原地排序
 */
public class SelectSort {
    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(int[] array) {
        // 数组长度
        int length = array.length;
        for (int i = 0; i < length; i++) {
            // 记录初始值为最小值
            int min = array[i];
            // 记录最小值位置
            int k = i;
            // 开始寻找剩余未排序的数组中的最小值
            for (int j = i + 1; j < length; j++) {
                // 没遇到比原来小的，就进行记录
                if (array[j] < min) {
                    min = array[j];
                    k = j;
                }
            }
            // 将最小的和初始值交换位置
            Util.swap(array, i, k);
        }
    }
}
