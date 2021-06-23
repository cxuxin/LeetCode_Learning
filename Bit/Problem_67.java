package Bit;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：\
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 链接：https://leetcode-cn.com/problems/add-binary/
 */

public class Problem_67 {
    public String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int m = a.length()-1;
        int n = b.length()-1;
        int flag = 0;
        while(m >=0 && n >=0){
            int sum = a.charAt(m) - '0' + b.charAt(n) - '0' + flag;
            stringBuffer.append(sum%2);
            flag = sum / 2;
            m--;
            n--;
        }
        if(m < 0){
            while(n >= 0){
                int sum = b.charAt(n) -'0' + flag;
                stringBuffer.append(sum % 2);
                flag = sum /2;
                n--;
            }
        }else{
            while(m >= 0){
                int sum = a.charAt(m) -'0' + flag;
                stringBuffer.append(sum % 2);
                flag = sum / 2;
                m--;
            }
        }
        if(flag != 0){
            stringBuffer.append(flag);
        }
        return stringBuffer.reverse().toString();
    }

    public String addBinary1(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int carry = 0;
        int n = Math.max(a.length(), b.length());
        for(int i = 0; i< n; i++){
            carry += i < a.length()?(a.charAt(a.length() - 1 - i) - '0'):0;
            carry += i < b.length()?(b.charAt(b.length() - 1 - i) - '0'):0;
            stringBuffer.append(carry % 2);
            carry /= 2;
        }
        if(carry != 0){
            stringBuffer.append(carry);
        }
        return stringBuffer.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new Problem_67().addBinary1("111110","1011"));
    }
}
