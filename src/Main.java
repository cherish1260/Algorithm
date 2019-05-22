import otherstruc.Queue;
import tree.BalanceTree;
import data.TreeNode;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int array[] = {9, 28, 44, 3, 4, 55, 19};
        // 排序测试
//        QuickSort.quickSort1(array, 0, array.length - 1);
//        MergeSort.mergeSort(array, 0, array.length - 1);
//        BubbleSort.bubbleSort(array);
//        InsertSort.insertSort(array);
//        SelectSort.selectSort(array);
//        HeapSort.heatSort(array);
//        Util.printArray(array);
//        查找
//        int pos = BitSearch.bitSearch(array, 44);
//        int pos = BitSearch.bsearch(array, 44);
//        if(pos == -1) {
//            System.out.println("没有找到指定的值");
//        } else {
//            System.out.println("要查找的值的下标为：" + pos);
//        }
//        DynamicArray dyArray = new DynamicArray(4);
//        dyArray.add(0, 5);
//        dyArray.add(1, 6);
//        dyArray.add(2, 7);
//        dyArray.add(3, 8);
//        dyArray.printArray();
//        dyArray.remove(3);
//        dyArray.printArray();
        TreeNode root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.rightChild.leftChild = new TreeNode(5);
        root.rightChild.rightChild = new TreeNode(6);
        root.rightChild.rightChild.leftChild = new TreeNode(7);
        root.rightChild.rightChild.leftChild.leftChild = new TreeNode(8);
        boolean isBalance = BalanceTree.isBalanceTree2(root);
        System.out.println(isBalance);
        List<String> list = BalanceTree.getPath(root);
        for (String str: list) {
            System.out.println(str);
        }
        System.out.println("--------先序遍历--------");
        BalanceTree.preTraverse(root);
        System.out.println("--------后序遍历--------");
        BalanceTree.postTraverse(root);
        System.out.println("--------中序遍历--------");
        BalanceTree.midTraverse(root);
        Queue queue = new Queue(5);
        queue.pop();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        BalanceTree.bfzTraverse(root);
    }
}
