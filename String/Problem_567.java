package String;

import java.util.HashMap;

public class Problem_567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c : s1.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, match = 0;
        int s1Len = s1.length();
        int s2Len = s2.length();
        while(r < s2Len){
            char c = s2.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    match++;
                }
            }
            while(r - l >= s1Len){
                if(match == need.size()){
                    return true;
                }
                char d = s2.charAt(l);
                l++;
                if(window.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        match--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
