package String;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Problem_20 {

    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>(){{
            put(']','[');
            put(')','(');
            put('}','{');
        }};
        Deque<Character> deque = new LinkedList<>();
        deque.push(s.charAt(0));
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(hashMap.containsKey(ch)){
                if(deque.isEmpty() || deque.peek() != hashMap.get(ch)){
                    return false;
                }
                deque.pop();
            }else {
                deque.push(ch);
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Problem_20().isValid("([)]"));
    }
}
