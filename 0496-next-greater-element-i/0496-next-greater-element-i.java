class Solution {
      public static int[] nextGreaterElement(int[]nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums2){
        while (!stack.empty() && stack.peek() < num ) {// so sanh voi stack[top] va so hien tai
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
}