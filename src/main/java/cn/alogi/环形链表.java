package cn.alogi;

public class 环形链表 {
    public static boolean isCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            while(fast.next == null || fast.next.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static ListNode firstCycleNode(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow, fast;
        slow = fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != null && fast.next != null && slow != fast);

        if(fast == null || fast.next == null) return null;
        ListNode tmp = head;
        while(tmp != slow){
            tmp = tmp.next;
            slow = slow.next;
        }
        return tmp;
    }
}
