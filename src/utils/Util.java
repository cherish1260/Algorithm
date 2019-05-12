package utils;

public class Util {
    /**
     * 打印数组的每个值
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i< array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    /**
     * 交换数组的指定两个下标的值
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
