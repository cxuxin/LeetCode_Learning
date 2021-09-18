package Interview.Huawei;

import java.util.*;

public class Inteview {
    public static void main(String[] args) {
        problem1();


    }

    public static void problem1(){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int[] m = new int[k];
        int[] n = new int[k];
        for(int i = 0; i < k; i++){
            String[] data = in.next().split(",");
            m[i] = Integer.parseInt(data[0]);
            n[i] = Integer.parseInt(data[1]);
        }
        int a = in.nextInt();
        int first = 1001;
        for(int i =0; i< k; i++){
            first = Math.min(first, m[i]);
        }
        int second = 1001;
        for(int i =0; i< k; i++){
            second = Math.min(second, n[i]);
        }

        System.out.println(Math.min(a, first + second));
    }

    public static void problem2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, ArrayList<String>> hashMap1  = new HashMap<>();
        HashMap<String, ArrayList<String>> hashMap2  = new HashMap<>();
        for(int i = 0; i < n;i++){
            String entity1 = in.next();
            String relation = in.next();
            String entity2 = in.next();
            if(relation.equals("subClassOf")){
                ArrayList<String> temp = hashMap1.getOrDefault(entity2,new ArrayList<String>());
                temp.add(entity1);
                hashMap1.put(entity2,temp);
            }else if(relation.equals("instanceOf")){
                ArrayList<String> temp = hashMap2.getOrDefault(entity2,new ArrayList<String>());
                temp.add(entity1);
                hashMap2.put(entity2,temp);
            }
        }
        String node = in.next();
        ArrayList<String> ans = new ArrayList<>();
        if(hashMap1.containsKey(node)){
            ArrayList<String> subClasses = hashMap1.get(node);
            for(String subClass:subClasses){
                if(hashMap1.containsKey(subClass)){
                    ArrayList<String> instances = hashMap2.get(node);
                    ans.addAll(instances);
                }
                if(hashMap2.containsKey(subClass)){
                    ArrayList<String> instances = hashMap2.get(subClass);
                    ans.addAll(instances);
                }

            }
            if(hashMap2.containsKey(node)){
                ArrayList<String> instances = hashMap2.get(node);
                ans.addAll(instances);
            }
        }else if(hashMap2.containsKey(node)){
            ArrayList<String> instances = hashMap2.get(node);
            ans.addAll(instances);
        }else{
            ans.add("empty");
        }
        Collections.sort(ans);
        System.out.println(ans.toString().replace("[","").replace("]","").replaceAll(",",""));
    }

    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] area = new int[M][N];
        for(int i = 0; i< M;i++){
            for(int j = 0; j< N; j++) {
                area[i][j] = in.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(area));
    }
}
