package Interview.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Userpre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] pre = new int[num];
        HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap<>();
        for(int i = 0; i < num; i++){
            pre[i] = scanner.nextInt();
            ArrayList<Integer> list = hashmap.getOrDefault(pre[i], new ArrayList<>());
            list.add(i);
            hashmap.put(pre[i],list);
        }

        int search_num = scanner.nextInt();
        for(int i = 0; i < search_num; i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            int count = 0;
            ArrayList<Integer> list = hashmap.get(k);
            System.out.println(list);
            if(list != null){
                for (Integer integer : list) {
                    if (integer < l-1 ) {
                        continue;
                    }
                    if(integer > r-1){
                        break;
                    }
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
