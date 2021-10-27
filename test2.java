import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class test2 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        return isSame(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right,root2);

    }
    public boolean isSame(TreeNode root1, TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val == root2.val){
            System.out.println(root1.val);
        }
        return root1.val == root2.val
                && isSame(root1.left, root2.left)
                && isSame(root1.right, root2.right);
    }

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        Mirror(pRoot);
        return pRoot;
    }

    public void mirrorDfs(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        mirrorDfs(root.left);
        mirrorDfs(root.right);
    }


    public static void main(String[] args) {
//        test2 test = new test2();
//        ArrayList<Integer> tree1 = new ArrayList<>(Arrays.asList(1,7,3,2,6,null,null,4,5));
//        ArrayList<Integer> tree2 = new ArrayList<>(Arrays.asList(2,4,5));
//        TreeNode root1  = TreeNode.createTree(tree1,0,tree1.size());
//        TreeNode root2  = TreeNode.createTree(tree2,0,tree2.size());
//        System.out.println(test.HasSubtree(root1, root2));
//        int[] seq = new int[]{1,4,2,3};
//        int[] in = Arrays.copyOf(seq, seq.length);
//        Arrays.sort(seq);

//        String s = "{1,2,3,#,#,6,7}";
//        System.out.println(Arrays.toString(s.split(",")));
//        ArrayList<String> list = new ArrayList<>(Arrays.asList("1","2","3","#","#","6","7"));
//        System.out.println(list);
//        StringBuffer sb = new StringBuffer();
//        sb.append("{");
//        sb.append(list.toString().replace("[","").replace("]",""));
//        sb.append("}");
//        System.out.println(sb.toString());
//        int a =  Integer.parseInt("1");

//        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b - a);
//        q.add(2);
//        System.out.println(q.peek());
//        q.add(3);
//        System.out.println(q.peek());
//        q.add(1);
//        System.out.println(q.peek());
//        System.out.println(q);

//        int a = 4;
//        System.out.println(~a);

        Stack<Character> stack = new Stack<>();
        stack.isEmpty();
    }
}
