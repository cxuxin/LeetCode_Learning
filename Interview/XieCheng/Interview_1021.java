package Interview.XieCheng;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Interview_1021 {

    //小程得到了一个仅由大写和小写字母组成的字符串，现在他可以进行如下操作任意次：
    //
    //选择字符串中的一个字符，如果它是一个大写字母，那么将其变为对应的小写字母；如果它是一个小写字母，那么将其变成对应的大写字母。
    //
    //小程想知道他至少需要进行多少次操作，才能使得字符串中没有连续两个相同的字符（ASCII码不同则视为两个不同的字符）。
    //
    //例如，对于字符串”abaaa”，小程可以进行一次操作，将其变为”abaAa”，该字符串不含连续两个相同的字符。
    //
    //
    //
    //输入描述
    //一行，一个仅包含大写字母和小写字母的字符串。
    //
    //n<=20000
    //
    //输出描述
    //一行，一个整数，表示小程至少需要进行的操作次数。
    //
    //
    //样例输入
    //aaaaabbb
    //样例输出
    //3
    public static void problem1() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        long ans1 = 0;
        char pre = s.charAt(0);
        for (int i = 1; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == pre) {
                ans1++;
                if(Character.isLowerCase(pre)) {
                    pre = Character.toUpperCase(pre);
                } else {
                    pre = Character.toLowerCase(pre);
                }
            } else {
                pre = cur;
            }
        }

        long ans2 = 0;
        pre = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == pre) {
                ans2++;
                if (Character.isLowerCase(pre)) {
                    pre = Character.toUpperCase(pre);
                } else {
                    pre = Character.toLowerCase(pre);
                }
            } else {
                pre = cur;
            }
        }
        System.out.println(Math.min(ans1, ans2));
    }

    //小程最近接了一份工作，是到游泳馆内做救生员。只要泳池内有人，他就必须坐在指定区域对泳池的安全状况进行观察。如果某段时间内泳池内一个人都没有，那么小程可以进行休息。
    //
    //假设这一天有n个时刻，现在告诉你这一天中m个人进入泳池的时刻和离开泳池的时刻，请你计算小程可以进行休息的时长。
    //
    //例如一天有12个时刻，有3 个人来过游泳馆，他们进入泳池的时刻分别是4、3、8，离开泳池的时刻分别是7、6，10。也就是说，3个人在泳池的时间段分别是[4, 7]、[3, 6]、[8, 10]。那么[1, 3]、[7, 8]、[10, 12]这三个时段泳池内是没有人的，小程可以进行休息，因此这一天小程可以休息的时长为2+1+2=5。
    //
    //
    //
    //输入描述
    //第一行两个正整数n和m，分别表示这一天有n个时刻，以及有m个人来游泳馆。
    //
    //第二行m个数，第i个数a[i]表示第i个人进入泳池的时刻。
    //
    //第三行m个数，第i个数b[i]表示第i个人离开泳池的时刻。
    //
    //数字间两两有空格隔开
    //
    //n<=1000000000, m<=50000, 1<=a[i]<b[i]<=n
    //
    //输出描述
    //一行，一个整数，表示小程可以休息的时长。
    //
    //
    //样例输入
    //12 3
    //4 3 8
    //7 6 10
    //样例输出
    //5
    public static void problem2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] times = new int[m][2];
        for (int i = 0; i < m; i++) {
            times[i][0] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            times[i][1] = in.nextInt();
        }
        Arrays.sort(times, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        ArrayList<int[]> merged = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int l = times[i][0];
            int r = times[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < l){
                merged.add(new int[]{l, r});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }
        long noRest = 0;
        for(int[] data: merged){
            int l = data[0];
            int r = data[1];
            noRest = noRest + (r - l);
        }
        System.out.println(n - 1 - noRest);
    }

    //小明最近在玩一个游戏。游戏中，所有敌人站成一排，编号为1…n。编号为i的敌人的血量为ai。小明每次可以使用连锁闪电攻击敌人。每一次使用连锁闪电时，小明会选择一个目标，接下来只要这个目标的旁边的敌人血量大于0，则小明可以决定是否让连锁闪电扩散到旁边的敌人。而这个被扩散到的敌人又可以扩散到这个敌人的旁边。每个敌人在一次连锁闪电的攻击中最多被攻击一次。每个被连锁闪电击中的目标血量会减少1。
    //
    //请问小明最少使用几次连锁闪电，就可以让所有的敌人血量归零呢？
    //
    //
    //
    //输入描述
    //第一行一个数，代表敌人的数量
    //
    //第二行n个数，代表每个敌人的血量。
    //
    //输出描述
    //输出一行一个数代表小明最少使用连锁闪电的次数。
    //
    //
    //样例输入
    //5
    //3 1 2 1 3
    //样例输出
    //6
    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for(int i = 0 ; i < n; i++){
            a[i] = in.nextLong();
        }
        System.out.println(dfs(a, 0, n));
    }

    public static long dfs(long[] a, int start, int end){
        if(start == end){
            return 0;
        }
        if(start + 1 == end){
            return a[start];
        }
        long min = Long.MAX_VALUE;
        for(int i = start; i < end; i++){
            min = Math.min(min, a[i]);
        }
        ArrayList<Integer> zeros = new ArrayList<>();
        for(int i = start; i < end; i++){
            a[i] = a[i] - min;
            if(a[i] == 0){
                zeros.add(i);
            }
        }
        long ans = min;
        if(zeros.size() != 0){
            ans += dfs(a, start, zeros.get(0));
            for(int i = 0; i < zeros.size() - 1; i++){
                ans += dfs(a, zeros.get(i) + 1, zeros.get(i + 1));
            }
            ans += dfs(a, zeros.get(zeros.size() - 1) + 1, end);
        }
        return ans;
    }

    public static void main(String[] args) {
        problem1();
    }
}

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