class KthLargest {
    final PriorityQueue<Integer> pq; // maintain a min heap
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k); // size k
        for(int num : nums) add(num); // constructor add num into stream
    }
    
    public int add(int val) {
        if(pq.size() < k ){ // pq not full
            pq.offer(val);
        }
        else if(pq.peek() < val){ // min num smaller than new num so update
        // the heap
        pq.poll(); // pop it out
        pq.offer(val); // add new val
        }
        return pq.peek(); // return the min num in heap
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */