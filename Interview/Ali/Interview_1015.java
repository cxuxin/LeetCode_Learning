package Interview.Ali;

import java.util.Arrays;
import java.util.Scanner;

public class Interview_1015 {
    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        long[] a = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextLong();
        }
        long[] sums = new long[n];
        long[] ans = new long[n];
        if(a[0] > c){
            ans[0] = c;
            sums[0] = c;
        }else{
            ans[0] = a[0];
            sums[0] = a[0];
        }
        for(int i = 1; i < n; i++){
            long sum = sums[i - 1] + a[i];
            if(sum > (long) (i + 1) * c){
                ans[i] = a[i] - (sum  - (long) (i + 1) * c) ;
                sums[i] = (long) (i + 1) * c;
            }else {
                ans[i] = a[i];
                sums[i] = sum;
            }
        }
        System.out.println(Arrays.toString(ans).replace("[","").replace("]","").replace(",",""));
    }
    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        long ans = 0;
        for(int i = 0; i < n - 1; i++){
            ans += Math.max(a[i], a[i + 1]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        problem1();
    }
}
