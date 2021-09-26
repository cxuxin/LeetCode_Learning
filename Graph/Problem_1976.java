package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_1976 {
    public static int countPaths(int n, int[][] roads) {
        final int MOD = (int) (1e9 + 7);
        long[] time = new long[n]; // 表示从路口0触发到路口i的最短用时
        long[] count = new long[n]; // 表示在最短用时情况下从路口0出发到路口i对应的方案数
        Arrays.fill(time, -1);
        Arrays.fill(count, 0);
        time[0] = 0; //路口0的到达用时为0
        count[0] = 1; //路口0的到达方案数为1

        // 构造邻接矩阵
        int[][] edges = new int[n][n]; // edges[i][j]表示从路口i到路口j的时间花费
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                edges[i][j] = -1;
            }
        }
        for(int[] road: roads){
            int u = road[0], v = road[1], t = road[2];
            edges[u][v] = t;
            edges[v][u] = t;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) ->a[1] - b[1]);
        for(int i = 0; i < n; i++){
            if(edges[0][i] > 0){
                pq.offer(new int[]{i, edges[0][i], 0}); // 初始化，加入与路口0直接相邻的路口
            }
        }
        while(!pq.isEmpty()){
            int[] node  = pq.poll(); // 当前最快到达的路口及时间
            int id = node[0], t = node[1], lastNode = node[2]; // 路口编号，到达时间，上一个路口
            if(time[id] != -1 && t > time[id]){ // 当前路径不是最短路径，跳过
                continue;
            }
            if(time[id] == -1){
                time[id] = t;
                count[id] = count[lastNode] % MOD;
                for(int i = 0; i < n; i++){
                    if(edges[id][i] != -1 && (time[i] == -1 || t + edges[id][i] <= time[i])){ // 更新可到达的
                        pq.offer(new int[]{i, t + edges[id][i], id});
                    }
                }
            }else{
                count[id] = (count[id] + count[lastNode]) % MOD;
            }
        }
        System.out.println(Arrays.toString(time));
        return (int) count[n-1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(countPaths(n, roads));
    }
}
