package String;

import java.util.HashMap;

public class Problem_3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            r++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while(window.get(c) > 1){
                char d = s.charAt(l);
                l++;
                window.put(d, window.get(d) - 1);
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
