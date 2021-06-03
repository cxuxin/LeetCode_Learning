package Array;

import java.util.HashMap;

/*
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 链接：https://leetcode-cn.com/problems/contiguous-array/
 */
public class Problem_525 {
    public int findMaxLength(int[] nums) {
        int n =nums.length;
        int count = 0, ans = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);
        for(int i = 0; i<n; i++){
            if(nums[i] == 0){
                count += -1;
            }else if(nums[i] == 1){
                count += 1;
            }
            if(hashMap.containsKey(count)){
                int pos = hashMap.get(count);
                ans = Math.max(ans, i - pos);

            }else{
                hashMap.put(count, i);
            }
        }
        return ans;
    }
}
