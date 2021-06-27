package Array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Problem_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int cur = m + n -1;
        while(left >= 0 || right >= 0){
            if(left == -1){
                nums1[cur--] = nums2[right--];
            }else if(right == -1){
                nums1[cur--] = nums1[left--];
            }else if(nums1[left] > nums2[right]){
                nums1[cur--] = nums1[left--];
            }else{
                nums1[cur--] = nums2[right--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new Problem_88().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
