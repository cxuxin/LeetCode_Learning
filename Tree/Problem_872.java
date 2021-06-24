package Tree;

import utils.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Simple 872. 叶子相似的树
* 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
* 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
* 如果给定的两个根结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
* 链接：https://leetcode-cn.com/problems/leaf-similar-trees
* */
public class Problem_872 {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, seq1);
        }
        List<Integer> seq2 = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, seq2);
        }
        return seq1.equals(seq2);
    }

    public static void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> tree1 = new ArrayList<>(Arrays.asList(3,5,1,6,2,9,8,null,null,7,4));
        ArrayList<Integer> tree2 = new ArrayList<>(Arrays.asList(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8));
        TreeNode root1  = TreeNode.createTree(tree1,0,tree1.size());
        TreeNode root2  = TreeNode.createTree(tree2,0,tree2.size());

        System.out.println(leafSimilar(root1, root2));
    }
}
