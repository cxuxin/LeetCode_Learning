import java.util.*;

public class test1 {
    public static boolean problem1(){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] arrays = new int[N][2];
        for(int i = 0; i < N; i++){
            arrays[i][0] = input.nextInt();
            arrays[i][1] = input.nextInt();
        }
        Arrays.sort(arrays, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(arrays[i][1] >= arrays[j][1]){
                    return true;
                }
            }

        }
        return false;
    }

    public static int[] problem2(){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] card1 = new int[N];
        int[] card2 = new int[N];
        for(int i = 0; i < N; i++){
            card1[i] = input.nextInt();
        }
        for(int i = 0; i < N; i++){
            card2[i] = input.nextInt();
        }
        int[] cards = new int[2 * N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count1 = 0;
        int count2 = 0;
        int index = 0;
        int total1 = 0;
        int total2 = 0;
        boolean isPlayer1 = true;
        while(count1 < N && count2 < N){
            int card = isPlayer1? card1[count1++] : card2[count2++];
            cards[index] = card;
            if(hashMap.containsKey(card)){
                int start = hashMap.get(card);
                if(isPlayer1){
                    for(int i = start; i <= index;i++){
                        if(cards[i] != 0){
                            total1++;
                        }
                    }
                }else{
                    for(int i = start; i <= index;i++){
                        if(cards[i] != 0){
                            total2++;
                        }
                    }
                }
                for(int i = start; i <= index; i++){
                    hashMap.remove(cards[i]);
                    cards[i] = 0;
                }
            }else{
                hashMap.put(card, index);
                isPlayer1 = !isPlayer1;
            }
            index++;
        }
        while(count1 < N){
            int card = card1[count1++];
            cards[index] = card;
            if(hashMap.containsKey(card)){
                int start = hashMap.get(card);
                for(int i = start; i <= index;i++){
                    if(cards[i] != 0){
                        total1++;
                    }
                }
                for(int i = start; i <= index; i++){
                    hashMap.remove(cards[i]);
                    cards[i] = 0;
                }
            }else{
                hashMap.put(card, index);
            }
            index++;
        }
        while(count2 < N){
            int card = card2[count2++];
            cards[index] = card;
            if(hashMap.containsKey(card)){
                int start = hashMap.get(card);
                for(int i = start; i <= index;i++){
                    if(cards[i] != 0){
                        total2++;
                    }
                }
                for(int i = start; i <= index; i++){
                    hashMap.remove(cards[i]);
                    cards[i] = 0;
                }
            }else{
                hashMap.put(card, index);
            }
            index++;
        }
        for (int card : cards) {
            if (card != 0) {
                if (card % 2 == 0) {
                    total2++;
                } else {
                    total1++;
                }
            }
        }
        return new int[]{total1,total2};
    }

    public static long problem4(){
        Scanner input = new Scanner(System.in);
        int[] arrays = new int[10];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            arrays[i] = input.nextInt();
            for(int j = 0; j < arrays[i];j++){
                arrayList.add(i);
            }
        }
        long left = 0;
        long right = 0;
        boolean isLeft = true;
        int length = arrayList.size();
        for(int i = length - 1; i>=0; i--){
            if(isLeft){
                left = left * 10 + arrayList.get(i);
            }else{
                right = right * 10 + arrayList.get(i);
            }
            isLeft = !isLeft;
        }
        System.out.println(left);
        System.out.println(right);
        return left * right;
    }

    public static void main(String[] args) {
//        System.out.println(problem1());
//        System.out.println(Arrays.toString(problem2()));
        System.out.println(problem4());
    }
}
