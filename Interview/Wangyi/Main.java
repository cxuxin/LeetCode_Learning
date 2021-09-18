package Interview.Wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void problem1(){
        String[] nums = new String[]{"0", "1", "01","1","01","101","01","1","01","101"};
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            StringBuilder sb = new StringBuilder();
            if((num % 10) % 2 == 0){
                if(num % 10 != 0){
                    sb.append("1");
                }
            }else{
                sb.append(nums[num % 10]);
            }
            num /= 10;
            while(num != 0){
                sb.append(nums[num % 10]);
                num /= 10;
            }
            String temp = sb.toString();
            StringBuilder ans = new StringBuilder();
            int count = 0;
            while(temp.charAt(count) == '0'){
                count++;
            }
            boolean flag = false;
            for(int j = count; j < temp.length(); j++){
                if(flag){
                    if(temp.charAt(j) == '0'){
                        ans.append('0');
                        flag = false;
                    }
                }else{
                    if(temp.charAt(j) == '1'){
                        ans.append('1');
                        flag = true;
                    }
                }
            }
            System.out.println(ans.toString());
        }
    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            int N = in.nextInt();
            int M = in.nextInt();
            int[] H = new int[N + 1];
            for(int i = 1; i <= N; i++){
                H[i] = in.nextInt();
            }
            ArrayList<Integer> top = new ArrayList<>();

            getTop(H, 1, N,top);
            int count = top.size();
            if(top.get(0) == 0){
                count--;
            }
            if(top.get(top.size() - 1) == N){
                count--;
            }
            System.out.println(count);
        }
    }

    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            int N = in.nextInt();
            int M1 = in.nextInt();
            int M2 = in.nextInt();
            HashMap<Integer,ArrayList<Integer>> simpleHashMap = new HashMap<>();
            HashMap<Integer,ArrayList<Integer>> magicHashMap = new HashMap<>();
            for(int i = 0; i < N; i++){
                simpleHashMap.put(i, new ArrayList<Integer>());
                magicHashMap.put(i, new ArrayList<Integer>());
            }
            for(int i = 0; i < M1; i++){
                int u = in.nextInt();
                int v = in.nextInt();
                simpleHashMap.get(u).add(v);
                simpleHashMap.get(v).add(u);
            }
            for(int i = 0; i < M2; i++){
                int u = in.nextInt();
                int v = in.nextInt();
                magicHashMap.get(u).add(v);
                magicHashMap.get(v).add(u);
            }
            System.out.println(1);
        }
    }

    public static void getTop(int[] H, int start, int length, ArrayList<Integer> top){
        if(start >= length){
            return;
        }
        int left = start;
        while(left + 1 <= length && H[left] <= H[left + 1]){
            left++;
        }
        if(left + 1 == length){
            return;
        }else{
            top.add(left);
            getTop(H,left+1,length,top);
        }


    }


    public static void main(String[] args) {
//        problem2();
        ArrayList<Integer> arrayList = new ArrayList<>();
        getTop(new int[]{0,0,1,0,3,2,1,3},1, 7, arrayList);
        System.out.println(arrayList);
    }
}
