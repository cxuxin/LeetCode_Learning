package Array;

import java.util.Arrays;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Problem_53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i< n;i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            if(ans < dp[i]){
                ans = dp[i];
            }
        }
        return ans;
    }
    public int maxSubArray1(int[] nums) {
        int pre = 0;
        int ans =nums[0];
        for(int num:nums){
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Problem_53().maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
