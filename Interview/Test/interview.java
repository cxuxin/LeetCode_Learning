package Interview.Test;

import utils.TreeNode;

import java.util.*;

public class interview {

    public static int[] slice(int[] num, int statIndex, int len){
        int n = num.length;
        if((statIndex + len) >= n){
            System.out.println("超出了范围");
            return new int[]{};
        }
        int[] newArr = new int[len];
        for(int i = 0; i< len; i++){
            newArr[i] = num[statIndex + i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(new interview().slice(a, 2, 5)));

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
