package Interview.Bilibili;

import java.lang.reflect.Array;
import java.util.*;

public class Interview_1013 {
    //[[0,0,1,0,0,0,0,1,0,0,0,0,0],
    // [0,0,0,0,0,0,0,1,1,1,0,0,0],
    // [0,1,1,1,1,0,0,0,0,0,0,0,0],
    // [0,1,0,0,1,1,0,0,1,0,1,0,0],
    // [0,1,0,0,1,1,0,0,1,1,1,0,0],
    // [0,0,0,0,0,0,0,0,0,0,1,0,0],
    // [0,0,0,0,0,0,0,1,1,1,0,0,0],
    // [0,0,0,0,0,0,0,1,1,0,0,0,0]]

    public static void problem1(){
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        while(in.hasNext()){
            String input = in.nextLine();
            String s = input.replace("[","").replace("]","");
            String[] line = s.split(",");
            ArrayList<String> temp = new ArrayList<>();
            temp.addAll(Arrays.asList(line));
            data.add(temp);
            if(input.endsWith("]]")) break;
        }
        int m = data.size();
        int n = data.get(0).size();
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dfs1(data, i, j));
            }
        }
        System.out.println(ans);
    }

    public static int dfs1(ArrayList<ArrayList<String>> data, int i, int j){
        if(i < 0 || i >= data.size() || j < 0 || j >= data.get(0).size() || !data.get(i).get(j).equals("1")){
            return 0;
        }
        data.get(i).set(j, "0");
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int ans = 1;
        for(int index = 0; index < 4; index++){
            ans += dfs1(data, i + dx[index], j + dy[index]);
        }
        return ans;
    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] xs = new int[500000 + 1];
        int[] ys = new int[500000 + 1];
        int max = 0;
        for(int i = 0; i < N; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            xs[x]++;
            ys[y]++;
            max = Math.max(max, Math.max(x, y));
        }
        int ans = 0;
        for(int i = 0; i <= max; i++){
            ans = Math.max(ans, Math.max(xs[i], ys[i]));
        }
        System.out.println(ans);
    }

    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cur = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> path = new HashMap<>();
        for(int i = 0; i < m; i++){
            String data = in.next();
            String[] temp = data.split(",");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            ArrayList<Integer> array1 = path.getOrDefault(start, new ArrayList<Integer>());
            array1.add(end);
            path.put(start, array1);
            ArrayList<Integer> array2 = path.getOrDefault(end, new ArrayList<Integer>());
            array2.add(start);
            path.put(end, array2);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        boolean[] isVisited = new boolean[n];
        dfs(hashSet, path, isVisited, cur);
        int ans = hashSet.size() - path.getOrDefault(cur, new ArrayList<>()).size();
        if(hashSet.contains(cur)){
            System.out.println(ans - 1);
        }else{
            System.out.println(ans);
        }
    }

    public static void dfs(HashSet<Integer> hashSet, HashMap<Integer, ArrayList<Integer>> path, boolean[] isVisited, int cur){
        if(isVisited[cur] || !path.containsKey(cur)){
            return;
        }
        isVisited[cur] = true;
        ArrayList<Integer> array = path.get(cur);
        for(int node : array){
            hashSet.add(node);
            dfs(hashSet, path, isVisited, node);
        }
    }

    public static void main(String[] args) {
        problem3();
    }
}
