/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // the best solution ever !!!
        /*
    if (headA == null || headB == null)    {
        return null;
    }
        ListNode a = headA;
        ListNode b = headB;
        while (a!=b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }*/
        int lenA = length(headA);
        int lenB = length(headB);
        // instead of implementing a move function
        // we will use while loop
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
       
   private int length (ListNode node){
       int length = 0;
        while(node !=null)   {
            node = node.next;
            length++;
        }
       return length;
   }
}