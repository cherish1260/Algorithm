import sort.*;

public class Main {

    public static void main(String[] args) {
        int array[] = {9, 28, 44, 3, 4, 55, 19};
//        QuickSort.quickSort1(array, 0, array.length - 1);
//        MergeSort.mergeSort(array, 0, array.length - 1);
//        BubbleSort.bubbleSort(array);
//        InsertSort.insertSort(array);
        SelectSort.selectSort(array);
        Util.printArray(array);
    }
}
