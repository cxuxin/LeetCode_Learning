package Interview.ByteDance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Chain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> hashmap = new HashMap<>();
        for(int i = 1; i <= n; i++){
            int color_num = scanner.nextInt();
            for(int j = 0; j< color_num;j++){
                int color = scanner.nextInt();
                ArrayList<Integer> list = hashmap.getOrDefault(color, new ArrayList<>());
                list.add(i);
                hashmap.put(color, list);
            }
        }
        int count = 0;
        for(int i = 1; i<= c;i++){
            ArrayList<Integer> list = hashmap.get(i);
            System.out.println(list);
            if(list.size() == 1){
                continue;
            }
            for(int j = 0; j < list.size(); j++){
                if(j == list.size() - 1){
                    if((list.get(j)%n) - list.get(0) <= m-1 ){
                        count++;
                        break;
                    }
                }else if(list.get(j+1) - list.get(j) <= m-1){
                    count++;
                    break;
                }
            }

        }
        System.out.println(count);
    }
}
