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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode startNode = new ListNode(0);
        startNode.next = head;
        ListNode fast = startNode;
        ListNode slow = startNode;
        for(int i = 0 ; i <= n; i++){
            // create a distance N between slow and fast pointers
            fast = fast.next;
        }
        while(fast != null){
            // maintain this distance between 2 pointers
            // and move it until fast is out of the list
            fast = fast.next;
            slow = slow.next;
        }
        // now the next node of the slow pointer is the node we need to remove
        // 1    2    3         4       5     null
        //          slow   (remove)         fast 
        slow.next = slow.next.next;
        return startNode.next;
    }
}