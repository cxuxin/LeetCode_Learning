package Interview.PDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Interview_1026 {
    static int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};

    //在多多王国中，『骑士』(knight) 只能走日字格。如下图所示，若灰色格子里的『骑士』，下一步能跳到的格子只能是图中所示8个红色格子之一。
    //多多王国是一个N*M的平面网格 (N行M列)，每个格子要不是『陆地』，要不是『海洋』。骑士每一步都只能跳到『陆地』格子上，骑士可以越过『海洋』格子跳到『陆地』格子上。
    // 现在给出骑士的当前格子和骑士要到达的目标格子，请问骑士最少需要多少步才能到达目标？
    // 输入描述: 第一行输入包含一个正整数 T (1 &lt;= T &lt;= 20)，表示接下来共有 T 组测试用例。
    // 对于每组测试用例，其第一行包含2个整数N和M (1&lt;= N, M &lt;= 500) ，表示多多王国格子图为N行M列。
    // 接下来有N行字符串，每行包含M个字符。其中，字符 '1' 表示陆地，字符 '0' 表示海洋，字符 'K' 表示骑士初始所在的位置，字符 'T' 表示骑士的目标位置。( 'K' 与 'T' 所在格子都是陆地)。
    // 每组输入数据中恰好包含1个字符'K'与一个字符'T'。
    // 输出描述:</h2> <pre><div>每组测试用例输出一行，包含一个整数，表示最少需要多少步才能走到目标格子。若骑士无法走到目标格子，则输出"-1"
    //
    // 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
    // 输入
    //5
    //4 4
    //K111
    //1111
    //1111
    //111T
    //2 3
    //K00
    //00T
    //4 4
    //K111
    //1101
    //1011
    //111T
    //3 3
    //KT1
    //111
    //111
    //3 3
    //K11
    //1T1
    //111
    // 输出
    //1
    //-1
    //3
    public static void problem1() {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int M = in.nextInt();
            char[][] datas = new char[N][M];
            int[] start = new int[2];
            int[] end = new int[2];
            for (int i = 0; i < N; i++) {
                String s = in.next();
                for (int j = 0; j < M; j++) {
                    char c = s.charAt(j);
                    if (c == 'K') {
                        start[0] = i;
                        start[1] = j;
                    }
                    if (c == 'T') {
                        end[0] = i;
                        end[1] = j;
                    }
                    datas[i][j] = c;
                }
            }
            System.out.println((back(datas, start[0], start[1], end)) ? 1 : -1);
        }
    }

    public static boolean back(char[][] datas, int cur_i, int cur_j, int[] end) {
        int N = datas.length;
        int M = datas[0].length;
        if (cur_i < 0 || cur_i >= N || cur_j < 0 || cur_j >= M || datas[cur_i][cur_j] == '0') {
            return false;
        }
        if (cur_i == end[0] && cur_j == end[1]) {
            return true;
        }
        datas[cur_i][cur_j] = '0';
        return back(datas, cur_i - 2, cur_j - 1, end) ||
                back(datas, cur_i - 2, cur_j + 1, end) ||
                back(datas, cur_i - 1, cur_j - 2, end) ||
                back(datas, cur_i - 1, cur_j + 2, end) ||
                back(datas, cur_i + 1, cur_j - 2, end) ||
                back(datas, cur_i + 1, cur_j + 2, end) ||
                back(datas, cur_i + 2, cur_j - 1, end) ||
                back(datas, cur_i + 2, cur_j + 1, end);

    }

    //现有n个数组，每个数组有m个数字。
    // 如果存在两个数组 i, j，分别删掉它们其中某一个数字后（不需要位置互相对应），这两个数组分别用剩下数字组成的和相等，那么则认为这两个数组的为等和数组对。
    // 求这 n 个数组中共有几个等和数组对，并输出答案。
    // 规定等和数组对用两个数组编号表示(i, j)，并且令 i &lt; j。
    // 输入描述:
    // 第一行 T 表示输入数据组数。
    // 接下来每组数据中：
    // 第一行输入三个数字 n, m。
    // 接下来 n 行代表 n 个数组，每行 m 个数字ai。
    // 输出描述:
    // 对于每组数据，如果没有解则输出一行 -1
    // 如果有解，每组数据首先输出一行数字 x，代表该组数据对应等和数组对的个数。
    // 接下来x行，每行输出两个数字 i, j，表示一个等和数组对，其中 i &lt; j。
    // 这 x 行的等和数组对，以 i 升序进行排列输出，如果 i 相等则以 j 升序进行排序输出。
    // 示例1
    // 输入输出示例仅供调试，后台判题数据一般不包含示例
    // 输入
    // 1
    //3 3
    //-7 -5 0
    //1 0 -5
    //9 8 -10
    //输出
    // 1
    //1 2
    // 说明
    // 第一个数组和第二个数组构成等和数组对，因为第一个数组删除 -7 的和为 -5，第二个数组删除 1 的和为 -5
    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[n][m];
            int[] sum = new int[n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    a[i][j] = in.nextInt();
                    sum[i] += a[i][j];
                }
                Arrays.sort(a[i]);
            }
            ArrayList<int[]> ans = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    int target = sum[j] - sum[i];
                    boolean flag = false;
                    for(int x = 0; x < m; x++){
                        if(flag) break;
                        for(int y = 0; y < m; y++){
                            if(a[j][y] - a[i][x] == target){
                                ans.add(new int[]{i + 1, j + 1});
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(ans.size());
            for (int[] an : ans) {
                System.out.println(an[0] + " " + an[1]);
            }
        }
    }

    //天气突然转凉，需要紧急给多多鸡的鸡棚盖上被子。鸡棚为一条直线上的M个小房间，每个房间可以住多只多多鸡。由于疫情原因，有一些多多鸡还在被隔离中，所以鸡棚没有住满。
    //你联系上了N家制造被子的小工厂，时间紧急每个工厂只能加工一床被子。一床被子可以盖住一段连续的小房间，每覆盖一个小房间需要用1公斤棉花。
    //我们需要保证鸡棚中的多多鸡晚上都能盖上被子，问最少需要多少公斤棉花。
    //输入描述:
    // 第一行输入是三个整数，C（1&lt;= C &lt;= 10000)，M(1 &lt;= M &lt;= 10000) ，N(1 &lt;= N &lt;= 1000)。
    // 分别表示有</b>C只多多鸡，<b>M个小房间，N个工厂。
    // 第二行为C个整数，每个整数表示第i只多多鸡的房间编号a[i], (1&lt;=a[i]&lt;=M)
    // 输出描述:输出为一个非负整数，表示最少需要多少公斤棉花。
    // 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
    // 输入
    // 5 7 2
    //2 5 2 6 7
    // 输出
    // 4
    // 说明
    // 共生产2床被子。
    // 第一床被子盖房间2号，花费1公斤棉花。
    // 第二床被子盖房间5、6、7号，花费3公斤棉花。
    // 共计4公斤棉花。
    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int C = in.nextInt();
        int M = in.nextInt();
        int N = in.nextInt();
        int[] a = new int[C];
        for(int i = 0; i < C; i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int ans = 1;
        int pre = a[0];
        for(int i = 1; i < C; i++){
            if(a[i] != pre){
                pre = a[i];
                ans++;
            }
        }
        System.out.println(ans);

    }

    // 多多有一张地图，地图由n行m列个格子组成，每个格子有一个分数a[i][j]，达到一个格子时，会获得格子上的分数，每个格子只能走一次。
    // 从左上角走到右下角，每次只能走上、下、右的相邻格子，不能向左走。在不重复走格子的情况下，到达终点时的总分数最高是多少。
    // 输入描述:
    // 第一行两个整数n,m
    // n行m列个整数a[i][j]，用空格隔开
    // 输出描述:
    // 输出一个整数，表示到达终点时的总分数最高是多少
    // 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
    // 输入
    // 3 3
    //1 1 1
    //1 1 1
    //1 1 1
    // 输出
    // 9
    // 示例2
    // 输入
    // 3 3
    // 1 -2 -2
    // 1 1 1
    // 1 1 1
    // 输出
    // 7
    // 备注:
    // 对于50%的数据，3 &lt;= n,m &lt;= 100
    // 对于100%的数据，3 &lt;= n,m &lt;= 1000,&nbsp; -100 &lt;= a[i][j] &lt;= 100
    public static void problem4() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
                ans += Math.max(a[i][j], 0);
            }
        }
        int[][] dp = new int[n][m];
        dp[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int a1 = Integer.MIN_VALUE;
                int a2 = Integer.MIN_VALUE;
                int a3 = Integer.MIN_VALUE;
                if (i + 1 < n) {
                    a1 = dp[i + 1][j];
                }
                if (i - 1 >= 0) {
                    a2 = dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    a3 = dp[i][j - 1];
                }
                dp[i][j] = Math.max(Math.max(a1, a2), a3) + a[i][j];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        problem2();
    }
}
