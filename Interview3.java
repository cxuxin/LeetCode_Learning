import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interview3 {
    public static int[] problem1(String s){
        Pattern pattern = Pattern.compile("[WASD]");
        Matcher matcher = pattern.matcher(s);
        String[] steps = matcher.replaceAll(".").split("[.]");
        System.out.println(Arrays.toString(steps));

        Pattern pattern1 = Pattern.compile("\\d?");
        Matcher matcher1 = pattern1.matcher(s);
        String[] dirs = matcher1.replaceAll("").split("");
        System.out.println(Arrays.toString(dirs));

        int[] ans = new int[2];
        for(int i = 0; i < dirs.length; i++){
            String dir = dirs[i];
            int step = 0;
            if(steps[i].equals("")){
                step = 1;
            }else{
                step = Integer.parseInt(steps[i]);
            }
            switch (dir) {
                case "D" -> ans[1] -= step;
                case "W" -> ans[1] += step;
                case "A" -> ans[0] -= step;
                case "S" -> ans[0] += step;
            }
        }
        return ans;
    }

    public static int problem2(){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        String s1 = input.next();
        String s2 = input.next();

        char[] charray1 = s1.toCharArray();
        char[] charray2 = s2.toCharArray();
        Arrays.sort(charray1);
        Arrays.sort(charray2);
        int ans = 0;
        for(int i = 0; i < charray1.length; i++){
            ans += Math.abs(charray1[i] - charray2[i]);
        }
        return ans;
    }

    public static int problem3(){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        if(N < 10){
            return N;
        }
        if(N > 45){
            return -1;
        }

        int ans = 0;
        int dig = 0;
        for(int i = 9; i > 0; i--){
            if(i <= N){
                N -= i;
                ans += (int)Math.pow(10,dig) * i;
                dig++;
            }
        }
        return ans;
    }

    public static long problem4(){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[] nums1 = new int[N];
        for(int i = 0; i < N; i++){
            nums1[i] = input.nextInt();
        }
        int[] nums2 = new int[N];
        nums2[0] = nums1[0] % M;
        for(int i = 1; i < N; i++){
            nums2[i] = (nums2[i - 1] + nums1[i]) % M;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        System.out.println(hashMap);
        System.out.println(Arrays.toString(nums2));
        long count = 0;
        for(int i = 0; i < N; i++){
            if(hashMap.containsKey(nums2[i])){
                count += hashMap.get(nums2[i]);
            }
            hashMap.put(nums2[i], hashMap.getOrDefault(nums2[i], 0) + 1);
            System.out.println(count);
            System.out.println(hashMap);
        }
        return count;
    }

    public static void main(String[] args) {

//        String s = "20DWS3A5W6S";
//        System.out.println(Arrays.toString(problem1(s)));

//        System.out.println(problem2());

//        System.out.println(problem3());

        System.out.println(problem4());

    }
}
