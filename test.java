import DP.Problem_518;
import com.sun.source.tree.Tree;
import utils.TreeNode;

import java.util.*;

public class test {
    public boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void isTrue(int[] nums){
        Deque<Integer> stack = new LinkedList<>();
        int minLeft = Integer.MAX_VALUE;
        for(int num: nums){
            if(num < minLeft){
                minLeft = num;
                stack.push(num);
            }else{
                while(!stack.isEmpty() && num >= stack.peek()){
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public List<Integer> preOrder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    public List<Integer> inOrder(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public List<Integer> postOrder(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }


    public static void main(String[] args) {

    }
}

