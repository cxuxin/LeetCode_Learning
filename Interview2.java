import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Interview2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[] arr = new int[N];
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++){
            arr[i] = input.nextInt();
            dp[i][i] = arr[i];
        }
        dp[0][0] = arr[0];
        for(int i = 1; i < N; i++){
            dp[0][i] = dp[0][i-1] + arr[i];
        }
        for(int i = 1; i< N; i++){
            for(int j = i+1; j < N; j++){
                dp[i][j] = dp[0][j] - dp[0][i - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        int ans = 0;
        for(int i = 0; i< N; i++){
            for(int j = i; j < N; j++){
                if(dp[i][j] % M == 0){
                    System.out.println(i  + "    "  + j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
