package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public static TreeNode createTree(ArrayList<Integer> tree, int i, int n){
            if(i >=n || tree.get(i)==null){
                return null;
            }
            TreeNode root = new TreeNode(tree.get(i));
            root.left = createTree(tree, 2 * i + 1, n);
            root.right = createTree(tree, 2 * i + 2, n);
            return root;
        }
        public static void preOrder(TreeNode root){
            if(root == null){
                return;
            }
            System.out.print(root.val + "  ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inOrder(TreeNode root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.val + "  ");
            inOrder(root.right);
        }
        public static void postOrder(TreeNode root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + "  ");
        }
        public static void levelOrder(TreeNode root){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                System.out.print(node.val + "  ");
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
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
    }


}
