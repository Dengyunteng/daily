package cn.alogi;

public class ReverseListNode {
    public static ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode temp = head;
        while(temp.next != null){
            ListNode tempNode = temp.next;
            temp.next = temp.next.next;
            tempNode.next = head;
            head = tempNode;
        }
        return head;
    }
}
