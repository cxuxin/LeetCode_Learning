package Interview.Huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Interview_0909 {

    /*
     * 有n级台阶，一次可以走1级，2级，3级，问：
     * 1.	一共有几种走法；
     * 2.	把第1题的所有走法都打印出来；
     * 3.	如果不考虑顺序，也就是先走1级再走2级和先走2级再走1级是同一个解，那有多少种走法；
     * 4.	把第3题的所有走法都打印出来。
     * 以上4题任选一题现场编码完成。
     *
     * 举例：n为4的情况
     * 共7种走法，打印出来分别是：
     * 1 1 1 1
     * 1 1 2
     * 1 2 1
     * 2 1 1
     * 2 2
     * 1 3
     * 3 1
     * 不考虑顺序的情况下，共4种走法，打印出来分别是：
     * 1 1 1 1
     * 1 1 2
     * 1 3
     * 2 2
     */
    public static void main(String[] args) {

//        System.out.println(solve1(4));
//        for (int i = 1; i < 10; i++) {
//            solve11(i);
//        }
//        solve2(5);
//        for(int i = 1; i < 10; i++){
//            solve33(i);
//        }
        solve4(4);
    }

    public static int solve1(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= 2; i++) {
            dp[i] = i;
        }
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void solve11(int n) {
        if (n <= 2) {
            System.out.println(n);
            return;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] steps = new int[]{1, 2, 3};
        for (int i = 1; i <= n; i++) {
            for (int step : steps) {
                if (i - step >= 0) {
                    dp[i] += dp[i - step];
                }
            }
        }
        System.out.println(dp[n]);
    }

    public static void solve2(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        getResult(res, path, n);
        System.out.println(res);
    }

    public static void getResult(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int n) {
        if (n == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (n >= i) {
                path.add(i);
                getResult(res, path, n - i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void solve3(int n) {
        int ans = 0;
        for (int i = 0; i <= n / 3; i++) {
            for (int j = 0; j <= (n - 3 * i) / 2; j++) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void solve33(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] steps = new int[]{1, 2, 3};
        for (int step : steps) {
            for (int i = step; i <= n; i++) {
                dp[i] += dp[i - step];
            }
        }
        System.out.println(dp[n]);
    }

    public static void solve4(int n){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        getResult2(ans, path, n, 3);
        System.out.println(ans);
    }

    private static void getResult2(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> path, int n, int coin) {
        if(n == 0){
            ans.add(new ArrayList<>(path));
            return;
        }else if(coin == 0){
            return;
        }
        for(int i = 0; i <= n / coin; i++){
            for(int k = 0; k < i; k++){
                path.add(coin);
            }
            getResult2(ans, path, n - coin * i, coin - 1);
            for(int k = 0; k < i; k++){
                path.remove(path.size() - 1);
            }
        }
    }


    public static void solve44(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= n / 3; i++) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                res.add(3);
            }
            for (int j = 0; j <= (n - 3 * i) / 2; j++) {
                ArrayList<Integer> path = new ArrayList<>(res);
                for (int k = 0; k < j; k++) {
                    path.add(2);
                }
                for (int k = 0; k < n - 2 * j - 3 * i; k++) {
                    path.add(1);
                }
                ans.add(path);
            }
        }
        System.out.println(ans);
    }

//    1：   1
//    2：   1，1    2
//    3：   1，1，1    2，1    1，2    3
}
