/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        boolean found =true;
        while(found){
            found=false;
            ListNode d = new ListNode(0);
            d.next=head;
            ListNode s=d;
            while(s.next!=null){
                int sum=0;
                ListNode e=s.next;
                while(e!=null){
                    sum+=e.val;
                    if(sum==0){
                        s.next=e.next;
                        found=true;
                        break;
                    }
                    e=e.next;
                }
                if(found) break;
                s=s.next;
            }
            head=d.next;
        }
        return head;
    }
}