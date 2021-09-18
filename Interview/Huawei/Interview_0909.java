package Interview.Huawei;

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
        System.out.println(solve(4));
    }

    public static int solve(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i - 3];
        }
        return dp[n];
    }

//    1：   1
//    2：   1，1    2
//    3：   1，1，1    2，1    1，2    3
}
