package Math;
/*
* Middle 1734. 解码异或后的排列
* 给你一个整数数组perm，它是前n个正整数的排列，且n是个 奇数。
* 它被加密成另一个长度为 n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。
* 比方说，如果perm = [1,3,2]，那么encoded = [2,1]。
* 给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。
* 示例 1：
* 输入：encoded = [3,1]
* 输出：[1,2,3]
* 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
* 示例 2：
* 输入：encoded = [6,5,4,6]
* 输出：[2,4,1,5,3]
* 提示：
* 3 <= n < 105
* n 是奇数。
* encoded.length == n - 1
* 链接：https://leetcode-cn.com/problems/decode-xored-permutation
* */

import java.util.Arrays;

public class Problem_1734 {
    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] perm = new int[n];
        int total = 0;
        for(int i = 1; i <= n; i++){
            total ^= i;
        }
        int odd = 0;
        for(int i = 1; i < n - 1;i+=2){
            odd ^= encoded[i];
        }
        perm[0] = total ^ odd;
        for(int i = 0; i<n-1;i++){
            perm[i+1] = perm[i] ^ encoded[i];
        }
        return perm;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{6, 5, 4, 6})));

    }
}
