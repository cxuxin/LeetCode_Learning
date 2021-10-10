package Interview.Meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Interview_1010 {
    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] ori = new int[n][3];
        int[][] rea = new int[m][3];
        for(int i = 0; i < n; i++){
            ori[i][0] = in.nextInt();
            ori[i][1] = in.nextInt();
            ori[i][2] = in.nextInt();
        }
        for(int i = 0; i < m; i++){
            rea[i][0] = in.nextInt();
            rea[i][1] = in.nextInt();
            rea[i][2] = in.nextInt();
        }
        int ans = 0;

        System.out.println(ans);
    }

    //3 3 2
    //1 2 0
    //5 6 1
    //8 10 1
    //0 3 0
    //5 6 0
    //7 9 1
    //4
    public static void problem11(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[1000000 + 1];
        int[] b = new int[1000000 + 1];
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);
        int maxOri = 0;
        for(int i = 0; i < n; i++){
            int start = in.nextInt();
            int end = in.nextInt();
            int val = in.nextInt();
            maxOri = end;
            Arrays.fill(a, start, end, val);
        }
        int maxRel = 0;
        for(int i = 0; i < m; i++){
            int start = in.nextInt();
            int end = in.nextInt();
            int val = in.nextInt();
            maxRel = end;
            Arrays.fill(b, start, end, val);
        }
        int maxNum = Math.max(maxOri, maxRel);
        int ans = 0;
        for(int i = 0; i < maxNum; i++){
            if(b[i] != -1){
                if(a[i] != b[i]){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] cost = new int[n];
        for(int i = 0; i < n; i++){
            cost[i] = in.nextInt();
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(cost[i] >= m) continue;
            int target = m - cost[i];
            for(int j = i + 1; j < n; j++){
                if(cost[j] <= target){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            c[i] = in.nextInt();
        }
        Arrays.sort(b);
        long[] ans = new long[n];
        for(int i = 0; i < n; i++){
            int start = getPos(b, c[i]);
            if(start + a[i] > m) ans[i] = -1;
            else{
                for(int j = 0; j < a[i]; j++){
                    ans[i] += b[start + j];
                }
            }
        }
        System.out.println(Arrays.toString(ans).replace(","," ").replace("[","").replace("]",""));
    }

    public static void problem4(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int maxInd = 0;
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            maxInd = (a[i] > a[maxInd]) ? i : maxInd;
        }
        int[] f = new int[n - 1];
        for(int i = 0; i < n - 1; i++){
            f[i] = in.nextInt();
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int res = getMax(a, f, i, j);
                ans[res]++;
            }
        }
        System.out.println(Arrays.toString(ans).replace(","," ").replace("[","").replace("]",""));
    }

    public static int getMax(int[] a, int[] f, int start, int end){
        int cur = start;
        while(start != end){
            start = f[start];
            if(a[start] > a[cur]){
                cur = start;
            }
        }
        return cur;
    }

    public static int getPos(int[] b, int target){
        int l = 0, r = b.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(b[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        problem11();
    }
}



//import java.util.*;
//class Main{
//    public static void main(String args[]){
//        int m;
//        double sum,n;
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            n=sc.nextInt();
//            m=sc.nextInt();
//            sum=0;
//            for(int i=0;i<m;i++){
//                sum=sum+n;
//                n=Math.sqrt(n);
//            }
//            System.out.printf("%.2f",sum);
//            System.out.println();
//        }
//    }
//}