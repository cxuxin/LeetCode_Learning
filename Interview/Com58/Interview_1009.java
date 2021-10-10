package Interview.Com58;

public class Interview_1009 {

    // "3[a2[c]]"
    // "accaccacc"
    public static String decodeString(String str) {
        // write code here
        StringBuffer sb = new StringBuffer();
        int n = str.length();
        int index = 0;
        while(index < n){
            while(index < n && Character.isLetter(str.charAt(index))){
                sb.append(str.charAt(index++));
            }
            int num = 0;
            while(index < n && Character.isDigit(str.charAt(index))){
                num =  num * 10 + str.charAt(index++) - '0';
            }
            num = (num == 0 ? 1 : num);
            if(index < n && str.charAt(index)=='['){
                int start = index++;
                int leftNum = 1;
                while(index < str.length() && leftNum != 0){
                    if(str.charAt(index) == '[') leftNum++;
                    else if(str.charAt(index) == ']') leftNum--;
                    index++;
                }
                String cur = decodeString(str.substring(start + 1, index - 1));
                for(int i = 0; i < num; i++){
                    sb.append(cur);
                }
                sb.append(cur.repeat(Math.max(0, num)));
            }
        }
        return sb.toString();
    }

    public static int calculateExtraNum(int totalNum, int exchangeNum) {
        // write code here
        if(totalNum < exchangeNum) return 0;
        int temp = totalNum / exchangeNum;
        int rest = totalNum % exchangeNum;
        return temp + calculateExtraNum(temp + rest, exchangeNum);
    }

//    public String getS(String s){
//        s = s.replace("[","").replace("]","");
//        StringBuffer temp = new StringBuffer();
//        int index = 0;
//        while(index < s.length() && Character.isLetter(s.charAt(index))){
//            temp.append(s.charAt(index++));
//        }
//        int num = 0;
//        while(index < s.length() && Character.isDigit(s.charAt(index))){
//            num =  num * 10 + s.charAt(index++) - '0';
//        }
//        num = (num == 0 ? 1 : num);
//        if(s.charAt(index)=='['){
//            int start = index;
//            while(index < s.length() && s.charAt(index) != ']'){
//                index++;
//            }
//            String cur = getS(s.substring(start, index));
//            temp.append(String.valueOf(cur).repeat(Math.max(0, num)));
//
//        }
//    }

    public static int StringSplit(String str) {
        // write code here
        int ans = 0;
        for(int i = 1; i < str.length() - 1; i++){
            ans = Math.max(ans, getCount(str.substring(0, i), 'a') + getCount(str.substring(i, str.length()), 'b'));
        }
        return ans;
    }

    public static int getCount(String s, char a){
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == a) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "[asdf]d";
        System.out.println(s.substring(0, s.length()));
//        System.out.println(decodeString("2[abc]3[cd]ef"));

//        System.out.println(calculateExtraNum(20, 4));
        System.out.println(StringSplit("abbbab"));
    }

}
