package String;

import java.util.HashMap;
import java.util.Map;

public class Problem_76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int tLen = t.length();
        for(int i = 0; i < tLen; i++){
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int len = Integer.MAX_VALUE;
        int ansL = -1, ansR = -1;
        int sLen = s.length();
        while(r < sLen){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
            }
            while(check(need, window)){
                if(r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = r;
                }
                char d = s.charAt(l);
                l++;
                if(window.containsKey(d)){
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check(HashMap<Character, Integer> need, HashMap<Character, Integer> window){
        for(Character c : need.keySet()){
            if(need.get(c) > window.getOrDefault(c, 0)){
                return false;
            }
        }
        return true;
    }

    public String minWindow1(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, match = 0;
        int len = Integer.MAX_VALUE;
        int ansL = -1, ansR = -1;
        int sLen = s.length();
        while(r < sLen){
            char c = s.charAt(r);
            r++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c)) ){
                    match++;
                }
            }
            while(match == need.size()){
                if(r - l < len){
                    len = r - l;
                    ansL = l;
                    ansR = r;
                }
                char d = s.charAt(l);
                l++;
                if(window.containsKey(d)){
                    window.put(d, window.get(d) - 1);
                    if(window.get(d) <= need.get(d)){
                        match--;
                    }
                }
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public String moban(String s, String t){
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for(char c : t.toCharArray()){
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int right = 0, left = 0, start = 0, match = 0;
        int res = Integer.MAX_VALUE;
        while(right < s.length()){
            char c1 = s.charAt(right);
            right++;
            if(needs.containsKey(c1)){
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if(window.get(c1).equals(needs.get(c1))){
                    match++;
                }
            }
            while(match == needs.size()){
                if(right - left < res){
                    start = left;
                    res = right - left;
                }
                char c2 = s.charAt(left);
                left++;
                if(needs.containsKey(c2)){
                    if(window.get(c2).equals(needs.get(c2))){
                        match--;
                    }
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                }
            }

        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, res + start);

    }
}

