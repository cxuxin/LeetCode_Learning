package Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Problem_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nodes = new ArrayList<>(Arrays.asList(4,2,7,1,3,6,9));
        TreeNode root = TreeNode.createTree(nodes, 0, nodes.size());
        TreeNode tree = new Problem_226().invertTree(root);
        TreeNode.levelOrder(tree);
    }
}
