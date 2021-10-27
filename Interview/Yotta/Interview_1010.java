package Interview.Yotta;
import java.util.*;
public class Interview_1010 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);

//        String s = "-12+(4+1)*2^(3^2-6)-7";
//        if(isAvail(s)){
//            System.out.println(getRes(s));
//        }else{
//            System.out.println("ERROR");
//        }

        String s = "-12+(4+1)*2^(-3^2--11)-7";
        System.out.println(calculate(s));
    }

    public static boolean isAvail(String s){
        int n = s.length();
        //if(n == 0) return true;
        if(n == 1) return Character.isDigit(s.charAt(0));
        char first = s.charAt(0);
        char last = s.charAt(n - 1);
        if(!Character.isDigit(first) && first != '-' && first != '(') return false;
        if(!Character.isDigit(last) && first != ')') return false;
        int num = 0;
        boolean isOp = false;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                isOp = false;
                continue;
            }
            else if(c == '+' || c == '-' || c == '*' || c == '^'){
                if(isOp){
                    return false;
                }
                isOp = true;
            }else if(c == '('){
                num++;
                isOp = false;
            }else if(c == ')'){
                num--;
                isOp = false;
            }
            else{
                return false;
            }
        }
        return num == 0;
    }

    public static int getRes(String s){
        //if(s.length() == 0) return 0;
        int n = s.length();
        int index = 0;
        while(index < n){
            char c = s.charAt(index);
            if(c == '('){
                int numK = 1;
                int start = index;
                int end = 0;
                while(numK != 0){
                    index++;
                    if(s.charAt(index) == ')') numK--;
                    else if(s.charAt(index) == '(') numK++;
                }
                end = index;//末尾）
                s = s.replace(s.substring(start, end + 1), String.valueOf(getRes(s.substring(start + 1, end))));
                n = s.length();
                index = start;
            }
            index++;
        }
        index = 0;
        n = s.length();
        while(index < n){
            char c = s.charAt(index);
            if(c == '^'){
                int a = 0;
                int b = 0;
                int pre = index - 1;
                int next = index + 1;
                while(pre >= 0 && Character.isDigit(s.charAt(pre))){
                    a = ((s.charAt(pre) - '0') * (int)Math.pow(10, index - pre - 1)) + a;
                    pre--;
                }
                while(next < n && Character.isDigit(s.charAt(next))){
                    b = b * 10 + s.charAt(next) - '0';
                    next++;
                }
                s = s.replace(s.substring(pre + 1 , next), String.valueOf((int)Math.pow(a, b)));
                index = pre;
                n = s.length();
            }
            index++;
        }
        index = 0;
        n = s.length();
        while(index < n){
            char c = s.charAt(index);
            if(c == '*'){
                int a = 0;
                int b = 0;
                int pre = index - 1;
                int next = index + 1;
                while(pre >= 0 && Character.isDigit(s.charAt(pre))){
                    a = ((s.charAt(pre) - '0') * (int)Math.pow(10, index - pre - 1)) + a;
                    pre--;
                }
                while(next < n && Character.isDigit(s.charAt(next))){
                    b = b * 10 + s.charAt(next) - '0';
                    next++;
                }
                s = s.replace(s.substring(pre + 1, next), String.valueOf((int)a * b));
                index = pre;
                n = s.length();
            }
            index++;
        }
        index = 0;
        n = s.length();
        int ans = 0;
        boolean firstNav = s.charAt(0) == '-';
        if(s.charAt(0) == '-'){
            index = 1;
            firstNav = true;
        }
        while(index < n && Character.isDigit(s.charAt(index))){
            ans = ans * 10 + s.charAt(index) - '0';
            index++;
        }
        if(firstNav) ans = -ans;
        while(index < n){
            char c = s.charAt(index);
            if(c == '+'){
                int a = 0;
                index++;
                while(index < n && Character.isDigit(s.charAt(index))){
                    a = a * 10 + s.charAt(index) - '0';
                    index++;
                }
                ans += a;
            }
            else if(c == '-'){
                int a = 0;
                index++;
                while(index < n && Character.isDigit(s.charAt(index))){
                    a = a * 10 + s.charAt(index) - '0';
                    index++;
                }
                ans -= a;
            }
        }
        return ans;
    }

    public static void cal(Stack<Integer> nums, Stack<Character> ops){
        if(nums.isEmpty() || nums.size() < 2) return ;
        if(ops.isEmpty()) return;
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();
        int res = 0;
        if(op == '+') res = a + b;
        else if(op == '-') res = a - b;
        else if(op == '*') res = a * b;
        else if(op == '/') res = a / b;
        else if(op == '^') res = (int)Math.pow(a, b);
        nums.push(res);
    }

    public static int calculate(String s){
        s = s.replaceAll(" ", "");
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        HashMap<Character, Integer> hashMap = new HashMap<>(){};
        hashMap.put('+', 1);
        hashMap.put('-', 1);
        hashMap.put('*', 2);
        hashMap.put('/', 2);
        hashMap.put('^', 3);
        nums.push(0);
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            System.out.println(nums);
            System.out.println(ops);
            System.out.println(c);
            if(c == '('){
                ops.push(c);
            }else if(c == ')'){
                while(!ops.isEmpty()){
                    if(ops.peek() != '('){
                        cal(nums, ops);
                    }else{
                        ops.pop();
                        break;
                    }
                }
            }else if(Character.isDigit(c)){
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i = i - 1;
                nums.push(num);
            }else{
                if(i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')){
                    System.out.println("add 0");
                    nums.push(0);
                }
                while(!ops.isEmpty() && ops.peek() != '('){
                    char prev = ops.peek();
                    if(hashMap.get(prev) >= hashMap.get(c)){
                        cal(nums, ops);
                    }else{
                        break;
                    }
                }
                ops.push(c);
            }
        }
        while(!ops.isEmpty()) cal(nums, ops);
        return nums.pop();
    }

}
