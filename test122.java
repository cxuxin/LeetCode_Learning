import java.util.HashMap;
import java.util.Stack;

public class test122 {
    public boolean isMatch(String s){
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(hashMap.containsKey(ch)){
               if(!stack.isEmpty() && stack.peek() == hashMap.get(ch)){
                   stack.pop();
               }else{
                   return false;
               }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
