package String;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class Problem_14 {
    public String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return s.substring(0,i);
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_14().longestCommonPrefix(new String[]{"ab","a"}));
    }
}
