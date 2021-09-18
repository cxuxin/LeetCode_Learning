package Interview.Wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Interview_0918_2 {
    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        int a = n;
        while(a != 0){
            int temp = a % 10;
            if (temp != 0) {
                if (n % temp == 0) {

                    ans++;
                }
            }
            a /= 10;
        }
        System.out.println(ans);
    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int m = in.nextInt();
        int n = s.length();
        int ans = n;
        int cur = 0;
        if(m == 0){
            while(cur < n-1){
                ans = ans +  (Math.abs(s.charAt(cur+1) - s.charAt(cur)) % 26);
                cur++;
            }
            System.out.println(ans);
            return;
        }

        while(cur < n){
            int num = getNoMagic(s, cur, m);
            if(cur + m >= n){
                ans += num;
            }else{
                ans += Math.min(num, m);
            }
            cur += m;
        }
        System.out.println(ans);
    }

    public static int getNoMagic(String s, int start, int m){
        int count = 0;
        int cur = start;
        int n = s.length();
        for(int i = 0; i < m; i++){
            cur++;
            if(cur == n){
                break;
            }
            count = count +  (Math.abs(s.charAt(cur) - s.charAt(cur - 1)) % 26);
        }
        return count;
    }

    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count_1 = 0;
        int count_total = 0;
        for(int i = 1; i <= n; i*=2){
            if((n & i) != 0){
                count_1++;
            }
            count_total++;
        }
        System.out.println(Math.min(count_1, count_total - count_1+1));
    }

    public static void problem4(){
        Scanner in = new Scanner(System.in);
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        char[][] road = new char[n][n];
        for(int i = 0; i < n; i++){
            String temp = in.next();
            for(int j = 0; j < n; j++){
                road[i][j] = temp.charAt(j);
            }
        }


    }

    public static void dfs(char[][] road, int i, int j){
        int n = road.length;
        if(i < 0 || i > n || j < 0 || j > n){
            return;
        }

    }

    public static void main(String[] args) {
        problem3();
    }
}
