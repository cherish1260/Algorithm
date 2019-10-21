import apple.laf.JRSUIUtils;
import array.DynamicArray;
import data.C;
import data.Node;
import diff.DiffMatchPatchUtil;
import link.ReverseLink;
import otherstruc.Queue;
import search.FindMid;
import sort.HeapSort;
import thread.Counter;
import thread.TestCallable;
import tree.BalanceTree;
import data.TreeNode;
import utils.Util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {

    public static String A = "A";
    public static String B = "B";

    public static void main(String[] args) {
//        testSort();
//        testSearch();
//        testTree();
//        testDynamicArray();
//        testDiff();
//        System.out.println(C.c);
//        testLink();
//        TestCallable testCallable = new TestCallable();
//        testCallable.testCall();
//        threadExample();
        testProxy();
    }

    private static void testProxy() {
        List<String> list = new ArrayList<>();
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(list, args);
            }
        });
        proxyInstance.add("hello");
        System.out.println(list);
    }

    private static void threadExample() {
        final Counter counter = new Counter();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
                }
            }).start();
        }
        System.out.println(counter);
    }

    /**
     * 死锁的例子
     */
    private static void deadLockExample() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        // 为了让当前线性不能立即获取到B锁
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("我是线程1");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("我是线程2");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    private static void testDiff() {
        String text1 = "hello world";
        String text2 = "hallo wod";
        DiffMatchPatchUtil diffMatchPatchUtil = new DiffMatchPatchUtil();
        LinkedList<DiffMatchPatchUtil.Diff> result = diffMatchPatchUtil.diff_main(text1, text2);
        System.out.println(result);

    }

    public static void testSort() {
        int array[] = {4, 5, 1, 6, 2, 7, 3, 8};
        // 排序测试
//        QuickSort.quickSort1(array, 0, array.length - 1);
//        MergeSort.mergeSort(array, 0, array.length - 1);
//        BubbleSort.bubbleSort(array);
//        InsertSort.insertSort(array);
//        SelectSort.selectSort(array);
        HeapSort.heatSort2(array);
        Util.printArray(array);

    }

    public static void testSearch() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        FindMid.FindMid(n1);
        // 查找
        // int pos = BitSearch.bitSearch(array, 44);
        // int pos = BitSearch.bsearch(array, 44);
        // if(pos == -1) {
        //     System.out.println("没有找到指定的值");
        // } else {
        //     System.out.println("要查找的值的下标为：" + pos);
        // }
    }

    public static void testTree() {
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
        for (String str : list) {
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
        System.out.println("------------------------");
        System.out.println("树的当前宽度为：" + BalanceTree.getWidth(root));
        System.out.println("树的当前高度为：" + BalanceTree.getTreeDepth(root));
    }

    public static void testDynamicArray() {
        DynamicArray dyArray = new DynamicArray(4);
        dyArray.add(0, 5);
        dyArray.add(1, 6);
        dyArray.add(2, 7);
        dyArray.add(3, 8);
        dyArray.printArray();
        dyArray.remove(3);
        dyArray.printArray();
    }

    public static void testLink() {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node result = ReverseLink.reverseLink2(node);
        Util.printNodeLink(result);
    }
}
