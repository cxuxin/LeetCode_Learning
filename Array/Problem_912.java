package Array;

import java.util.Arrays;
import java.util.Random;

public class Problem_912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int start, int end){
        if(start >= end) return;
        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    public static int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while(left != right){
            while(left < right && nums[right] > pivot){
                right--;
            }
            while(left < right && nums[left] <= pivot){
                left++;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[start] = nums[left];
        nums[left] = pivot;
        return left;
    }


    public static void quickSort1(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int pos = new Random().nextInt(end - start + 1) + start;
        int pivot = nums[pos];
        nums[pos] = nums[start];
        nums[start] = pivot;
        int left = start, right = end;
        while(left != right){
            // 必须从右边开始的原因是 如果从左边开始 left停下来的位置一定比基准大
            while(left < right && nums[right] > pivot){
                right--;
            }
            while(left < right && nums[left] <= pivot){
                left++;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[start] = nums[left];
        nums[left] = pivot;
        quickSort1(nums, start, left - 1);
        quickSort1(nums, left + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        quickSort(nums, 0 , nums.length - 1);
        System.out.println(Arrays.toString(nums));


        int[] nums1 = new int[]{-2,3,-5};
        quickSort1(nums1, 0 , nums1.length - 1);
        System.out.println(Arrays.toString(nums1));
    }
}
