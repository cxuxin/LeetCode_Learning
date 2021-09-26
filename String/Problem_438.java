package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(char c : p.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, match = 0;
        int sLen = s.length();
        int pLen = p.length();
        while(r < sLen){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    match++;
                }
            }
            while(r - l >= pLen){
                if(match == need.size()){
                    ans.add(l);
                }
                char d = s.charAt(l);
                l++;
                if(window.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        match--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return ans;

    }
}
