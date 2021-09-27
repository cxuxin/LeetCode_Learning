package Interview.Tencent;

import java.util.*;

public class Interview_0926 {
//    public static void problem11(){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for(int k = 0; k < n; k++){
//            int x = in.nextInt();
//            int ans = (x + 1) * (2 * x + 1);
//            while(true){
//                ArrayList<Integer> res = getNums(ans);
//                if(res.size() == 4){
//                    boolean flag = true;
//                    for(int i = 1; i < res.size(); i++){
//                        if(res.get(i) - res.get(i - 1) < x){
//                            ans++;
//                            flag = false;
//                            break;
//                        }
//                    }
//                    if(flag){
//                        System.out.println(ans);
//                        break;
//                    }
//                }else{
//                    ans++;
//                }
//            }
//        }
//    }

    public static boolean isQuality(int x){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= (int)Math.sqrt(x); i++){
            if(x % i == 0){
                if(res.size() > 0){
                    return false;
                }
                res.add(i);
                res.add(x / i);
            }
        }
        return res.size() == 2;

    }


    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int k = 0; k < n; k++){
            int x = in.nextInt();
            int a = 0, b = 0;
            for(int i = x + 1; ;i++){
                if(isQuality(i)){
                    a = i;
                    break;
                }
            }
            for(int i = a + x;;i++){
                if(isQuality(i)){
                    b = i;
                    break;
                }
            }
            System.out.println(a * b);
        }

    }


//    public static void problem2(){
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        for(int k = 0; k < T; k++){
//            int n = in.nextInt();
//            int[] a = new int[n];
//            int[] scores = new int[n];
//            Arrays.fill(scores, -1);
//            for(int i = 0; i < n; i++){
//                a[i] = in.nextInt();
//            }
//            int ans = 0;
//            int cur = 0;
//            for(int i = n - 1; i >= 0; i--){
//                cur = i;
//                int score = a[cur];
//                if(scores[i] != -1){
//                    score += scores[i];
//                }else{
//                    while(cur + a[cur] < n){
//                        score += a[cur + a[cur]];
//                        cur = cur + a[cur];
//                    }
//                    scores[cur] = score - a[i];
//                }
//                ans = Math.max(ans, score);
//            }
//            System.out.println(ans);
//        }
//    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int k = 0; k < T; k++){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] scores = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = in.nextInt();
            }
            int ans = 0;
            for(int i = n - 1; i >= 0; i--){
                if(i + a[i] >= n) scores[i] = a[i];
                else scores[i] = scores[i + a[i]] + a[i];
                ans = Math.max(ans, scores[i]);
            }
            System.out.println(Arrays.toString(scores));
            System.out.println(ans);
        }
    }

    public static void problem3(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stack<Long> stack = new Stack<Long>();
        int count = 0;
        long first = 0;
        while(s.charAt(count) >= '0' && s.charAt(count) <= '9'){
            first = first * 10 + s.charAt(count) - '0';
            count++;
        }
        stack.push(first);
        long num = 0;
        char sign = s.charAt(count);
        for(int i = count + 1; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            }
            if(c < '0' || c > '9' || i == s.length() - 1){
                long pre = 0;
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == 'x'){
                    pre = stack.pop();
                    stack.push(pre * num);
                }else if(sign == '@'){
                    pre = stack.pop();
                    stack.push(pre | (pre+num));
                }
                sign = c;
                num = 0;
            }
        }
        long ans = 0;
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        System.out.println(ans);

    }
    public void problem4(){
        Scanner in = new Scanner(System.in);

    }
    public void problem5(){
        Scanner in = new Scanner(System.in);

    }

    public static void main(String[] args) {
        problem2();
    }
}
