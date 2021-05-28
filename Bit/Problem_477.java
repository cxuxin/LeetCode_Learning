package Bit;

import java.sql.SQLOutput;

/**
 * 477. 汉明距离总和
 * 两个整数的汉明距离指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * 输入: 4, 14, 2
 * 输出: 6
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 * 链接：https://leetcode-cn.com/problems/total-hamming-distance
 */
public class Problem_477 {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < 30; i++){
            int temp = 0;
            for(int val:nums){
                temp += (val >> i) & 1;
            }
            ans += temp * (n-temp);
        }
        return ans;
    }

    // 暴力破解
    public int totalHammingDistance2(int[] nums){
        int n = nums.length;
        int ans = 0;
        for(int  i =0; i<n;i++ ){
            for(int j = i+1;j<n;j++){
                ans += getHammingDistance(nums[i], nums[j]);

            }
        }
        return ans;
    }
    public int getHammingDistance(int i, int j){
        return Integer.bitCount(i^j);
    }

    public static void main(String[] args) {
        System.out.println(new Problem_477().totalHammingDistance(new int[]{4,14,2}));
    }
}
