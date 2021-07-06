package utils;

import java.util.*;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(ArrayList<Integer> tree, int i, int n) {
        if (i >= n || tree.get(i) == null) {
            return null;
        }
        TreeNode root = new TreeNode(tree.get(i));
        root.left = createTree(tree, 2 * i + 1, n);
        root.right = createTree(tree, 2 * i + 2, n);
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "  ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "  ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + "  ");
    }

    public static void preOrderNoRec(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + "  ");
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    public static void inOrderNoRec(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void postOrderNoRec(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || prev == root.right) {
                System.out.print(root.val + "  ");
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> tree = new ArrayList<>(Arrays.asList(3, 9, 20, null, null, 15, 7));
        TreeNode root = TreeNode.createTree(tree, 0, tree.size());
        TreeNode.preOrder(root);
        System.out.println();
        TreeNode.inOrder(root);
        System.out.println();
        TreeNode.postOrder(root);
        System.out.println();
        TreeNode.levelOrder(root);
        System.out.println();
        TreeNode.preOrderNoRec(root);
        System.out.println();
        TreeNode.inOrderNoRec(root);
        System.out.println();
        TreeNode.postOrderNoRec(root);
    }


}
