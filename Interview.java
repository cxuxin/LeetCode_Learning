import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Interview {
    public static int[] problem(String order) {
        int x = 0;
        int y = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('W', 0);
        map.put('A', 0);
        map.put('S', 0);
        map.put('D', 0);
        System.out.println(Arrays.toString(order.split("[WASD]")));
        System.out.println(Arrays.toString(order.split("[\\d+]")));
        for (int i = 0; i < order.length(); i++) {
            if (Character.isLetter(order.charAt(i))) {
                if (i == 0 || Character.isLetter(order.charAt(i - 1))) {
                    map.put(order.charAt(i), map.get(order.charAt(i)) + 1);
                } else {
                    int num = (int) order.charAt(i - 1) - '0';
                    map.put(order.charAt(i), map.get(order.charAt(i)) + num);
                }
            }
        }
        x = x - map.get('A') + map.get('D');
        y = y - map.get('S') + map.get('W');
        return new int[]{x, y};
    }

    public static int[] problem2(String order) {
        int[] ans = {0, 0};
        int step = 1;
        for (char c : order.toCharArray()) {
            if (c == 'A') {
                ans[0] -= step;
            } else if (c == 'W') {
                ans[1] += step;
            } else if (c == 'S') {
                ans[1] -= step;
            } else if (c == 'D') {
                ans[0] += step;
            } else {
                step = (int) c - '0';
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(problem("W23D2A3S")));

    }
}



