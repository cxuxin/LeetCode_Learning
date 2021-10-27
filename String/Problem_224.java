package String;

import java.util.LinkedList;
import java.util.Stack;

public class Problem_224 {
    public int calculate(String s){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        int sign = 1;
        int ans = 0;
        int n = s.length();
        int index = 0;
        while(index < n){
            char c = s.charAt(index);
            System.out.println(ans);
            System.out.println(c);
            System.out.println(stack);
            if(c == ' '){
                index++;
            }else if(c == '+'){
                sign = stack.peek();
                index++;
            }else if(c == '-'){
                sign = -stack.peek();
                index++;
            }else if(c == '('){
                stack.push(sign);
                index++;
            }else if(c == ')'){
                stack.pop();
                index++;
            }else{
                int num = 0;
                while(index < n && Character.isDigit(s.charAt(index))){
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
//                System.out.println(sign);
//                System.out.println(num);
                ans += sign * num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem_224().calculate("1-(-4-5+2)-3+(6-8)"));
    }

}
