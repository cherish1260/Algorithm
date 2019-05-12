import search.BitSearch;
import sort.*;
import utils.Util;

public class Main {

    public static void main(String[] args) {
        int array[] = {9, 28, 44, 3, 4, 55, 19};
        // 排序测试
//        QuickSort.quickSort1(array, 0, array.length - 1);
//        MergeSort.mergeSort(array, 0, array.length - 1);
//        BubbleSort.bubbleSort(array);
//        InsertSort.insertSort(array);
        SelectSort.selectSort(array);
        Util.printArray(array);
//        查找
//        int pos = BitSearch.bitSearch(array, 44);
        int pos = BitSearch.bsearch(array, 44);
        if(pos == -1) {
            System.out.println("没有找到指定的值");
        } else {
            System.out.println("要查找的值的下标为：" + pos);
        }

    }
}
