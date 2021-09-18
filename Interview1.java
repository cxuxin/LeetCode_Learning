import java.util.Arrays;

public class Interview1 {
    public static boolean isIP(String s){
        String[] ip = s.split("[.]");
        System.out.println(Arrays.toString(ip));
        if(ip.length != 4){
            return false;
        }
        for(String s1 : ip){
            if(s1.split("\\d+").length == 0){
                return false;
            }
            int num = 0;
            try{
                num = Integer.parseInt(s1);
            }catch(Exception e){
                return false;
            }

            if(num < 0 || num > 255 ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIP("aaa.bbb.ccc.ddd"));

    }
}
