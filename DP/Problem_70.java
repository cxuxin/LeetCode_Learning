package DP;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 链接：https://leetcode-cn.com/problems/climbing-stairs/
 */
public class Problem_70 {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int[] ans = new int[n + 1];
        ans[1] = 1;
        ans[2] = 2;
        for(int i = 3; i <= n; i++){
            ans[i] = ans[i -1] + ans[i-2];
        }
        return ans[n];
    }
    public int climbStairs1(int n) {
        if(n <= 2){
            return n;
        }
        int pre = 1;
        int next = 2;
        int ans = 2;
        for(int i = 3; i <= n; i++){
            ans += pre;
            pre = next;
            next = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_70().climbStairs(7));
    }
}
