package Array;

import java.util.HashMap;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 *
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class Inteview_17_10 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int large = 0;
        for(int num : nums){
            if(count == 0){
                large = num;
            }
            if(num == large){
                count++;
            }else{
                count--;
            }
        }
        count = 0;
        for(int num : nums){
            if(num == large){
                count++;
            }
        }
        return count * 2 > nums.length? large : -1;
    }

    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length / 2;
        for(int num : nums){
            int count = hashMap.getOrDefault(num, 0) + 1;
            hashMap.put(num, count);
            if(count > n){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Inteview_17_10().majorityElement(new int[]{1,2,5,9,5,9,5,5,5}));
    }
}
