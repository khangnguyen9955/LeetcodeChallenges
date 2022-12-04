class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode tail = result;
        // use this priority queue to maintain the first smallest nodes of each linked list.
        PriorityQueue<ListNode> pQueue = new PriorityQueue<ListNode>(lists.length,(a,b)->a.val-b.val);
        for(ListNode listNode: lists ){
            if(listNode != null){
                pQueue.add(listNode);
            }
        }
        while(!pQueue.isEmpty()){
            tail.next = pQueue.poll(); // get the first node in the queue and remove it, cause min priority queue => smallest node will be added into the front of queue.
            tail=tail.next;
            if(tail.next != null){ // if the linked list still contain any nodes, add it to the queue 
                // means that replace the node that we just take out of the queue with this node
                pQueue.add(tail.next);
            }
        }
        return result.next;
    }
    
}