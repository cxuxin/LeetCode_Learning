package Math;

import Bit.Problem_67;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * 链接；https://leetcode-cn.com/problems/sqrtx/
 */
public class Problem_69 {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int ans = 1;
        while(x / ans >= ans){
            ans++;
        }
        return ans -1;
    }

    public int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r){
            int mid = (r-l) % 2 + l;
            if((long) mid * mid <= x){
                ans = mid;
                l = mid +1;
            }else{
                r = mid -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_69().mySqrt1(2147395600));
    }

}
