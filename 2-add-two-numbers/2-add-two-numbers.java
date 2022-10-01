class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = 0; 
        ListNode sum = new ListNode(2019); // dummy head
        ListNode cur = sum;
        while (l1 != null || l2 != null || val != 0) { // termination condition is critical
            if (l1 != null) {
                val = val + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val = val + l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            val = val / 10;
        }
        
        return sum.next;
    }
}