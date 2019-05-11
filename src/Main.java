import sort.MergeSort;
import sort.QuickSort;
import sort.Util;

public class Main {

    public static void main(String[] args) {
        int array[] = {9, 28, 44, 3, 4, 55, 19};
//        QuickSort.quickSort1(array, 0, array.length - 1);
        MergeSort.mergeSort(array, 0, array.length - 1);
        Util.printArray(array);
    }
}
