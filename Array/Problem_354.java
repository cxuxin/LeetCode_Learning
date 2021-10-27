package Array;

import java.util.Arrays;
import java.util.Comparator;

public class Problem_354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        System.out.println(Arrays.deepToString(envelopes));
        return 0;
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
//        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : b[1] - a[1]);
        System.out.println(Arrays.deepToString(envelopes));
    }
}
