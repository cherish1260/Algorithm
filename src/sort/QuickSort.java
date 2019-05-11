package sort;

public class QuickSort {

    /**
     * 大量使用了交换
     *
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort1(int[] array, int start, int end) {
        // 以起始点为选定的值
        int value = array[start];
        // 分别记录start、end索引
        int left = start;
        int right = end;
        // 递归结束点为left < right
        while(left < right) {
            // 先从右向左与选定的值进行比较，如果大于选定值，则继续，否则跳出
            while(left < right && array[right] > value) {
                right--;
            }
            // 如果符合结束条件，则交换左右下标的值，并left++
            if (left < right) {
                Util.swap(array, left, right);
                left++;
            }
            // 从左向右与选定的值进行比较，如果小于选定值，则继续，否则跳出
            while(left < right && array[left] < value) {
                left++;
            }
            // 如果符合结束条件，则交换左右下标的值，并right--
            if (left < right) {
                Util.swap(array, left, right);
                right--;
            }
        }
        if (left > start) {
            quickSort1(array, start, left-1);
        }
        if (right < end) {
            quickSort1(array, right + 1, end);
        }
    }

    /**
     * 减少了部分的交换代码
     *
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort2(int[] array, int start, int end) {
        // 以起始点为选定的值
        int value = array[start];
        // 分别记录start、end索引
        int left = start;
        int right = end;
        // 递归结束点为left < right
        while(left < right) {
            // 先从右向左与选定的值进行比较，如果大于选定值，则继续，否则跳出
            while(left < right && array[right] > value) {
                right--;
            }
            // 如果符合结束条件，则将右下标的值赋值给左下标位置（最初的left位置的值已被记录），并left++
            if (left < right) {
                array[left] = array[right];
                left++;
            }
            // 从左向右与选定的值进行比较，如果小于选定值，则继续，否则跳出
            while(left < right && array[left] < value) {
                left++;
            }
            // 如果符合结束条件，则将左下标的值赋值给右下标位置，并right--
            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        // 将最初记录的value赋值到最终的left位置
        array[left] = value;
        if (left > start) {
            quickSort1(array, start, left-1);
        }
        if (right < end) {
            quickSort1(array, right + 1, end);
        }
    }

    /**
     * 先找到分界点，再进行排序
     *
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort3(int[] array, int start, int end) {
        if (start < end) {
            int p = partition(array, start, end);
            quickSort3(array, start, p - 1);
            quickSort3(array, p + 1, end);
        }
    }

    /**
     * 找到分界点
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        // 记录最后下标的值
        int temp = array[end];
        // i用于记录最后一个小于temp值的位置，i+1即为temp的最终位置
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < temp) {
                i++;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, i + 1, end);
        return i + 1;
    }



}
