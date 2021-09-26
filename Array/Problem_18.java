package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<List<Integer>> triples = threeSumTarget(nums, i + 1, target - nums[i]);
            for(List<Integer> triple : triples){
                triple.add(nums[i]);
                ans.add(triple);
            }
            while(i < n - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSumTarget(int[] nums, int start, int target){
        int n = nums.length;
        List<List<Integer>> res  = new ArrayList<>();
        for(int i = start; i < n; i++){
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for(List<Integer> tuple : tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while(i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int n = nums.length;
        int l = start, r = n - 1;
        List<List<Integer>> res = new ArrayList<>();
        while(l < r){
            int sum = nums[l] + nums[r];
            int left = nums[l], right = nums[r];
            if(sum < target){
                while(l < r && nums[l] == left) l++;
            }else if(sum > target){
                while(l < r && nums[r] == right) r--;
            }else{
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while(l < r && nums[l] == left) l++;
                while(l < r && nums[r] == right) r--;
            }
        }
        return res;
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target){
        int numLen = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n < 2 || numLen < n) return res;
        if(n == 2){
            int l = start, r = numLen - 1;
            while(l < r){
                int sum = nums[l] + nums[r];
                int left = nums[l], right = nums[r];
                if(sum < target){
                    while(l < r && nums[l] == left) l++;
                }else if(sum > target){
                    while(l < r && nums[r] == right) r--;
                }else{
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while(l < r && nums[l] == left) l++;
                    while(l < r && nums[r] == right) r--;
                }
            }
        }else{
            for(int i = start; i < numLen; i++){
                List<List<Integer>> subs = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for(List<Integer> sub : subs){
                    sub.add(nums[i]);
                    res.add(sub);
                }
                while(i < numLen - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
