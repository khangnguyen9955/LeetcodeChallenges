/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode q = head;
        ListNode p = head;
        Boolean isCycle = false;
        
        if(head == null){
            return null;
        }
        
        while(q != null && p != null && q.next != null){
            q = q.next.next;
            p = p.next;
            if(p == q){
                isCycle = true;
                break;
            }    
        }
        
        if(isCycle){
            q = head;
            while(q != null && p != null){
                if(q== p){
                    return q;
                }
                q = q.next;
                p = p.next;
            }
        }
        
        return null;
    }
}