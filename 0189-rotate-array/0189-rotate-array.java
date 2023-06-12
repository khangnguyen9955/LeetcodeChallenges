class Solution {
  public static void rotate(int[] nums, int k) {
     // every k
        // swap last num to first
        // move rest nums to right by 1
        int len = nums.length;
        // for(int i = 0 ; i < k ; i++){
        //     // store last num as temp
        //     int tmp = nums[len-1];
        //     // move all to right by 1
        //     for(int j = len -1  ; j >= 1 ; j--){
        //         nums[j] = nums[j-1];
        //     }
        //     nums[0] = tmp;
        // }
                int [] test = new int [len+k];
        for (int i = 0; i < len; i++) {
            test[i+k] = nums[i];
        }
        for (int i = 0; i <test.length ; i++) {
            nums[i%len] = test[i];
        }
    }
}