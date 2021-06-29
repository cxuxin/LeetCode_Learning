package Tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/
 */

public class Problem_101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode p, TreeNode q){
        if(p== null && q==null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        ArrayList<Integer> tree = new ArrayList<>(Arrays.asList(1, 2, 2, null, 3, null, 3));
        TreeNode root = TreeNode.createTree(tree, 0, tree.size());
        System.out.println(new Problem_101().isSymmetric(root));
    }
}
