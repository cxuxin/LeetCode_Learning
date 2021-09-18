package Interview.Tencent;


import java.util.*;

public class Interview_0905 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode solve(ListNode[] a) {
        // write code here
        int n = a.length;
        if(n == 0){
            return null;
        }
        ListNode start = new ListNode(-1);
        ListNode p = start;
        Queue<ListNode> queue = new LinkedList<ListNode>();
        for (ListNode listNode : a) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            p.next = cur;
            p = p.next;
            if(cur.next != null){
                queue.add(cur.next);
            }
        }
        return start.next;
    }

    public static int problem2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = in.nextInt();
        }
        int[] att1 = new int[n];
        int[] att2 = new int[n];
        for(int i = 0; i < n; i++){
            att1[i] = getAtt(a[i]);
            att2[i] = getAtt(b[i]);
        }
        Arrays.sort(att1);
        Arrays.sort(att2);
        int ans = 0;
        int left = 0;
        int right = 0;
        while(left < n){
            if(att1[left] > att2[right]){
                ans++;
                left++;
                right++;
            }else{
                left++;
            }
        }
        return ans;
    }

    public static int getAtt(int num) {
        if(num == 1){
            return 1;
        }
        int res = 2;
        int round = (int) Math.sqrt(num);
        for(int i = 2; i <= round; i++){
            if(num % i == 0){
                if(num / i != i){
                    res = res + 2;
                }
                else{
                    res++;
                }
            }
        }
        return res;
    }


    public static void problem3(){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int count0 = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                count0++;
            }
        }
        int count1 = n - count0;
        int remain = 0;
        if(count0 > count1){
            int start0 = 0;
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '0'){
                    start0 = i;
                    break;
                }
            }
            int end0 = n -1;
            for(int i = n -1; i>=0; i--){
                if(s.charAt(i) == '0'){
                    end0 = i;
                    break;
                }
            }
            if(start0 != 0){
                remain += start0 * (start0 + 1) / 2;
            }
            if(end0 != n -1){
                int temp = n - 1 - end0;
                remain += temp * (temp + 1) / 2;
            }
        }else{
            int start1 = 0;
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '1'){
                    start1 = i;
                    break;
                }
            }
            int end1 = n -1;
            for(int i = n -1; i>=0; i--){
                if(s.charAt(i) == '1'){
                    end1 = i;
                    break;
                }
            }
            if(start1 != 0){
                remain += start1 * (start1 + 1) / 2;
            }
            if(end1 != n -1){
                int temp = n - 1 - end1;
                remain += temp * (temp + 1) / 2;
            }
        }

        int max = Math.max(count0, count1);
        System.out.println((max * (max + 1)) / 2 + remain);

    }

//    public static void main(String[] args) {
////        ListNode first = new ListNode(1);
////        first.next = new ListNode(2);
////        first.next.next = new ListNode(3);
////        ListNode second = new ListNode(4);
////        second.next = new ListNode(5);
////        ListNode third = new ListNode(7);
////        third.next = new ListNode(8);
////        third.next.next = new ListNode(9);
////        third.next.next.next = new ListNode(10);
////        third.next.next.next.next = new ListNode(11);
////        third.next.next.next.next.next = new ListNode(12);
////
////        ListNode ans = solve(new ListNode[]{first, second, third});
////        while(ans != null){
////            System.out.println(ans.val);
////            ans = ans.next;
////        }
////        for(int i = 1; i <= 16; i++){
////            System.out.println(getAtt(i));
////        }
////
////
////        System.out.println(problem2());
//        problem3();
//
//
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int r = in.nextInt();


        ArrayList<Integer> array = new ArrayList<>();
        int ans = 0;
        for(int i = l; i <= r; i++){
            if(array.get(i) == 1){
                ans++;
            }
        }
        System.out.println(ans);

    }
}
