package Interview.Wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class Interview_0918_1 {
    /**
     * 3 3
     * 1 2 4 8 6
     * 2 0 5 1 7
     * 3 4 0 0 8
     * 4 5 0 3 1
     * 5 0 0 4 2
     * 6 7 1 9 0
     * 7 0 2 6 0
     * 8 1 3 0 9
     * 9 6 8 0 0
     */
    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int nums = N * M;
        int[][] ans = new int[N + 1][M + 1];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums; i++){
            int id = in.nextInt();
            int left = in.nextInt();
            int up = in.nextInt();
            int right = in.nextInt();
            int down = in.nextInt();
            hashMap.put("" + left + " " + up , id);

        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                int left = ans[i][j-1];
                int up = ans[i-1][j];
                ans[i][j] = hashMap.get("" + left + " " + up);
            }
        }
        for(int i = 1; i <=N; i++){
            for(int j = 1; j < M; j++){
                System.out.print(ans[i][j]);
                System.out.print(" ");
            }
            if(M != 1){
                System.out.print(ans[i][M]);
            }
            System.out.println();
        }


    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int N = in.nextInt();
        int[][] data = new int[N][2];
        int max_x = 0;
        int max_y = 0;
        for(int i = 0; i < N; i++){
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
            max_x = Math.max(max_x, data[i][0]);
            max_y = Math.max(max_y, data[i][1]);
        }
        int maxHit = 0;
        int[] ans = new int[2];
        for(int i = max_x + R; i >= 0; i--){
            for(int j = max_y + R; j >= 0; j--){
                int hitNum = getHitNum(data, i, j, R*R);
                if(maxHit < hitNum){
                    maxHit = hitNum;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1]);

    }

    public static int getHitNum(int[][] data, int x, int y, int range){
        int n = data.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if((x - data[i][0]) * (x - data[i][0]) + (y - data[i][1]) * (y - data[i][1]) <= range){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        problem2();

    }
}
