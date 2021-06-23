package Bit;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 *
 * 提示：
 * 输入必须是长度为 32 的 二进制串 。
 *
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Offer_15 {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int ans = 0;
        for(int i = 0; i< s.length();i++){
            if(s.charAt(i) == '1'){
                ans++;
            }
        }
        return ans;
    }

    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int ret = 0;
        for(int i = 0; i< 32; i++){
            if((n & (1<<i)) != 0){
                ret++;
            }
        }
        return ret;
    }

    public int hammingWeight3(int n) {
        int ret = 0;
        while(n != 0){
            n &= n -1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Offer_15().hammingWeight3(Integer.parseUnsignedInt("11111111111111111111111111111101",2)));
    }
}
