package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_17 {
    public static HashMap<Character, String> hashMap = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        hashMap.put('2', "abc");
        hashMap.put('3', "def");
        hashMap.put('4', "ghi");
        hashMap.put('5', "jkl");
        hashMap.put('6', "mno");
        hashMap.put('7', "pqrs");
        hashMap.put('8', "tuv");
        hashMap.put('9', "wxyz");
        StringBuffer output = new StringBuffer();
        back(ans, output, digits, 0);
        return ans;
    }

    public static void back(List<String> ans, StringBuffer output, String digits, int index){
        if(index == digits.length()){
            ans.add(output.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = hashMap.get(digit);
        for(int i = 0; i < letters.length(); i++){
            output.append(letters.charAt(i));
            back(ans, output, digits, index + 1);
            output.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
