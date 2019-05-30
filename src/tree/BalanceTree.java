package tree;

import data.TreeNode;

import java.util.*;

public class BalanceTree {

    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.leftChild);
        int rightDepth = getTreeDepth(root.rightChild);
        int tmpLength = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        return tmpLength;
    }

    public static boolean isBalanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getTreeDepth(root.leftChild);
        int rightDepth = getTreeDepth(root.rightChild);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        } else {
            return isBalanceTree(root.leftChild)&& isBalanceTree(root.rightChild);
        }
    }

    /**
     * 判断是否是一颗平衡二叉树
     * @param root
     * @return
     */
    public static boolean isBalanceTree2(TreeNode root) {
        Height depth = new Height(0);
        return isBalanceTree2(root, depth);
    }

    /**
     * 后序遍历，其会先将左右孩子遍历，同时记录深度，可只遍历一次
     * @param root
     * @param depth
     * @return
     */
    public static boolean isBalanceTree2(TreeNode root, Height depth) {
        if (root == null) {
            depth = new Height(0);
            return true;
        }
        Height left = new Height(0), right = new Height(0);
        if (isBalanceTree2(root.leftChild, left) && isBalanceTree2(root.rightChild, right)) {
            int diff = left.height - right.height;
            if (diff <= 1 && diff >= -1) {
                depth.height = 1 + Math.max(left.height, right.height);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取所有路径
     * @param root
     * @return
     */
    public static List<String> getPath(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        iterator(root,list, "");
        return list;
    }

    /**
     * 先序遍历，遇到叶子节点路径结束，接入list
     * @param root
     * @param list
     * @param s
     */
    private static void iterator(TreeNode root, List<String> list, String s) {
        s = s + root.i + " ";
        if (root.leftChild == null && root.rightChild == null) {
            list.add(s.trim().replace(" ", "->"));
        }
        if (root.leftChild != null) {
            iterator(root.leftChild, list, s);
        }
        if (root.rightChild != null) {
            iterator(root.rightChild, list, s);
        }
    }

    /**
     * 先序遍历
     * @param root
     */
    public static void preTraverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.i);
            preTraverse(root.leftChild);
            preTraverse(root.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postTraverse(TreeNode root) {
        if (root != null) {
            postTraverse(root.leftChild);
            postTraverse(root.rightChild);
            System.out.println(root.i);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void midTraverse(TreeNode root) {
        if (root != null) {
            midTraverse(root.leftChild);
            System.out.println(root.i);
            midTraverse(root.rightChild);
        }
    }

    /**
     * 广度优先
     * @param root
     */
    public static void bfTraverse(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.println(node.i);
                    if (node.leftChild != null) {
                        queue.add(node.leftChild);
                    }
                    if (node.rightChild != null) {
                        queue.add(node.rightChild);
                    }
                }
            }
        }
    }

    /**
     * 广度优先
     *
     * 使用seq + 两个队列，可以实现z形打印
     * @param root
     */
    public static void bfzTraverse(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue1 = new LinkedList<>();
            queue1.add(root);
            Queue<TreeNode> queue2 = new LinkedList<>();
            int seq = 0; // 0：顺序，1：逆序
            while(!queue1.isEmpty() || !queue2.isEmpty()) {
                TreeNode node;
                if (seq == 0) {
                    node = queue1.poll();
                    if (node != null) {
                        System.out.println(node.i);
                        if (node.rightChild != null) {
                            queue2.add(node.rightChild);
                        }
                        if (node.leftChild != null) {
                            queue2.add(node.leftChild);
                        }
                        if (queue1.isEmpty()) {
                            seq = 1 - seq;
                        }
                    }
                } else {
                    node = queue2.poll();
                    if (node != null) {
                        System.out.println(node.i);
                        if (node.leftChild != null) {
                            queue1.add(node.leftChild);
                        }
                        if (node.rightChild != null) {
                            queue1.add(node.rightChild);
                        }
                        if (queue2.isEmpty()) {
                            seq = 1 - seq;
                        }
                    }
                }

            }
        }
    }

    /**
     * 深度优先
     * @param root
     */
    public static void dfTraverse(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    System.out.println(node.i);
                    if (node.rightChild != null) {
                        stack.add(node.rightChild);
                    }
                    if (node.leftChild != null) {
                        stack.add(node.leftChild);
                    }
                }
            }
        }
    }

    /**
     * 获取二叉树的宽度
     * 主要思想：使用广度优先，记录每层的宽度，最终选择最大的宽度
     *
     * @param root
     * @return
     */
    public static int  getWidth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0 ;
        } else {
            queue.add(root);
        }
        int width = 1;
        int preLevelWidth = 1;
        TreeNode node = null;
        while (!queue.isEmpty()) {
            while(preLevelWidth != 0) {
                node = queue.poll();
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
                preLevelWidth--;
            }
            if (queue.size() > width) {
                width = queue.size();
            }
            preLevelWidth = queue.size();
        }
        return width;
    }
}
