package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void problem(){
        Scanner in = new Scanner(System.in);
        ArrayList<String> data = new ArrayList<>();
        String input = in.nextLine();
        String[] datas = input.split(" ");
        Arrays.sort(datas);
        int n = datas.length;
        if(n == 1){
            System.out.println(datas[0]);
        }else{
            for(int i = 0; i < n - 1; i++){
                System.out.print(datas[i] + " ");
            }
            System.out.print(datas[n - 1]);
        }

    }
    int a = 1;

    public void addtest(int a){
        a++;
    }
    public static void main(String[] args) {
        test test1 = new test();
        int a = 1;
        test1.addtest(a);
        System.out.println(a);

//        problem();
    }
}
