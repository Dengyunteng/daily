package cn.alogi;

public class 回文字符串 {
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode reverse = null;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next == null){//奇数
            reverse = slow;
        }else{//偶数
            reverse = slow.next;
        }
        ListNode rt = reverse;
        while(rt.next != null){
            ListNode temp = rt.next;
            rt.next = rt.next.next;
            temp.next = reverse;
            reverse = temp;
        }
        slow.next = null;
        while(head != null && reverse != null){
            if(head.val != reverse.val){
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.next = new ListNode(0);
        l.next.next = new ListNode(0);
        System.out.println(isPalindrome(l));
    }
}
