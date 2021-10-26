package Interview.Redcampus;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Interview_1023 {
    //时间限制： 3000MS
    //内存限制： 589824KB
    //题目描述：
    //小红书邀请用户参与新兴线下生活方式的体验活动，每个活动有编号从1到n。每个活动之间有依赖关系，例如滑雪III（编号5）依赖滑雪II（编号3），[3,5]表示用户需要先完成3再完成5。为方便大家使用，组委会提供了一个查询依赖的功能，该功能输入[x,y]，若x是y需要进行的前置活动，则返回true。请实现这一功能
    //
    //
    //
    //
    //
    //输入描述
    //n = 5
    //
    //relations = [[1,3], [1,2], [3,2], [2,4], [3,5]]
    //
    //queries = [[1,5], [1,4], [4,5], [4,2]]
    //
    //输出描述
    //[1, 1, 0, 0]
    //
    //
    //样例输入
    //5
    //5 2
    //1 3
    //1 2
    //3 2
    //2 4
    //3 5
    //4 2
    //1 5
    //1 4
    //4 5
    //4 2
    //样例输出
    //1 1 0 0
    //
    //提示
    //2 <= n <= 100
    //
    //1 <= queries.length <= 10^3
    //
    //queries[i][0] != queries[i][1]
    //
    //图中不存在环
    public static int[] checkDependency(int n, int[][] relations, int[][] queries) {
        int qLen = queries.length;
        int rLen = relations.length;
        int[] ans = new int[qLen];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for(int i = 0; i < rLen; i++){
            int start = relations[i][1];
            int end = relations[i][0];
            ArrayList<Integer> temp = hashMap.getOrDefault(start, new ArrayList<Integer>());
            temp.add(end);
            hashMap.put(start, temp);
        }

        for(int i = 0; i < qLen; i++){
            ans[i] = bfs(queries, i, hashMap);
        }
        return ans;
    }

    public static int bfs(int[][] queries, int i, HashMap<Integer, ArrayList<Integer>> hashMap){
        int start = queries[i][1];
        int end = queries[i][0];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int len = hashMap.getOrDefault(cur, new ArrayList<>()).size();
            for(int j = 0; j < len; j++){
                int next = hashMap.get(cur).get(j);
                if(next == end){
                    return 1;
                }
                queue.add(next);
            }
        }
        return 0;
    }

    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int[] res;

        int n;
        n = Integer.parseInt(in.nextLine().trim());

        int relations_rows = 0;
        int relations_cols = 0;
        relations_rows = in.nextInt();
        relations_cols = in.nextInt();

        int[][] relations = new int[relations_rows][relations_cols];
        for(int relations_i=0; relations_i<relations_rows; relations_i++) {
            for(int relations_j=0; relations_j<relations_cols; relations_j++) {
                relations[relations_i][relations_j] = in.nextInt();
            }
        }


        int queries_rows = 0;
        int queries_cols = 0;
        queries_rows = in.nextInt();
        queries_cols = in.nextInt();

        int[][] queries = new int[queries_rows][queries_cols];
        for(int queries_i=0; queries_i<queries_rows; queries_i++) {
            for(int queries_j=0; queries_j<queries_cols; queries_j++) {
                queries[queries_i][queries_j] = in.nextInt();
            }
        }


        res = checkDependency(n, relations, queries);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }

    //时间限制： 3000MS
    //内存限制： 589824KB
    //题目描述：
    //薯队长最近在研究一个整数序列问题，就是在一个整数数组a中，他希望找出这个整数序列的一个子序列，使得子序列中各元素的乘积可以用若干个互不相同的质数相乘得到。
    //
    //比方说，如果a = [1, 2, 3, 4]，当取出来的子序列是[2, 3] 、[1, 2, 3] 和 [1, 3]都可以，因为他们的乘积是6、6和3，都是满足条件的，但是[1]和[4]就不行，因为乘积是1、4并不满足。
    //
    //现在，薯队长想知道请你计算，有多少种子序列满足条件，注意，子序列是可以删除若干个，也可以一个都不删除，不同下标的去除也视为不同的序列。
    //
    //由于结果比较大，薯队长只要知道结果对10^8 + 7取余的结果就行
    //
    //注意数组a的长度 <= 10^5，且每个元素在1～35之间（包括1和35）
    //
    //
    //
    //输入描述
    //第一行输入n
    //
    //第二行输入n个数字
    //
    //输出描述
    //一行，即取余的结果
    //
    //
    //样例输入
    //4
    //1 2 3 4
    //样例输出
    //6
    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        int[] zhishu = new int[]{1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        int len = zhishu.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            hashMap.put(zhishu[i], i);
        }
        int[] nums = new int[len];
        for(int i = 0; i < n; i++){
            if(hashMap.containsKey(a[i])){
                nums[hashMap.get(a[i])]++;
            }
        }
        int MOD = 100000007;
        int ans = 0;
        for(int i = 1; i < len; i++){
            ans = (ans + nums[i]) % MOD;
        }
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(nums[i] != 0){
                array.add(nums[i]);
            }
        }
        int size = array.size();
        for(int i = 2; i <= size; i++){
            ans = (ans + multi(array, i) ) % MOD;
        }
//        ans += multi(array,2);
//        int sum = 1;
//        for(int i = 0; i < size; i++){
//            sum = (sum * array.get(i)) % MOD;
//        }
//        ans += sum;
        System.out.println(ans);
    }

    public static int multi(ArrayList<Integer> array, int num){
        int res = 0;
        int MOD = 100000007;
        int n = array.size();
        if(num == 2){
            for(int i = 0 ; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    res = (int)((res + array.get(i) * array.get(j)) % MOD);
                }
            }
        }else if(num == 3){
            for(int i = 0 ; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    for(int k = j + 1; k < n; k++){
                        res = (int)((res + array.get(i) * array.get(j) * array.get(k)) % MOD);
                    }
                }
            }
        }else if(num == 4){
            for(int i = 0 ; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    for(int k = j + 1; k < n; k++){
                        for(int a = k + 1; a < n; a++){
                            res = (int)((res + (array.get(i) * array.get(j)) % MOD * (array.get(k) * array.get(a)) % MOD) % MOD);
                        }
                    }
                }
            }
        }else if(num == 5){
            for(int i = 0 ; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    for(int k = j + 1; k < n; k++){
                        for(int a = k + 1; a < n; a++){
                            for(int b = a + 1; b < n; b++){
                                res = (int)((res + array.get(i) * array.get(j) * array.get(k) * array.get(a)* array.get(b)) % MOD);
                            }
                        }
                    }
                }
            }
        }

        return res;
    }


    //时间限制： 3000MS
    //内存限制： 655360KB
    //题目描述：
    //判断一个句子是否可以用指定词库完全分词。
    //
    //
    //
    //输入描述
    //第一行是一个字符串数组，表示一组词库
    //
    //第二行是一个文本，表示要检查的文本内容
    //
    //输出描述
    //该文本是否能用输入的词组分词成功
    //
    //
    //样例输入
    //my name is red
    //ismynamered
    //样例输出
    //true
    public static void problem3(){
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine();
        String[] dicts = ss.split(" ");
        HashSet<String> dict = new HashSet<>();
        Collections.addAll(dict, dicts);
        String judged = in.next();
        int left = 0;
        int right = 0;
        int len = judged.length();
        while(right < len){
            right++;
            if(dict.contains(judged.substring(left, right))){
                System.out.println(judged.substring(left, right));
                left = right;
            }
        }
        System.out.println((left == right) ? "true" : "false");
    }

    public static void main(String[] args) {
        problem3();
    }

}
