package Bit;

/*
 * 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：2^4 = 16
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 * 提示：
 * -231 <= n <= 231 - 1
 * 链接：https://leetcode-cn.com/problems/power-of-two/
 */

public class Problem_231 {
    // 位运算 n & (n-1) == 0
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
    // 位运算 n & (-n) == n
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (-n)) == n;
    }
    // 数1的个数
    public boolean isPowerOfTwo2(int n){
        return n > 0 && Integer.bitCount(n) ==1;
    }
    // 递归
    public boolean isPowerOfTwo3(int n) {
        if(n<= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n%2 != 0){
            return false;
        }else{
            return isPowerOfTwo3(n/2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem_231().isPowerOfTwo(4));
    }

}
