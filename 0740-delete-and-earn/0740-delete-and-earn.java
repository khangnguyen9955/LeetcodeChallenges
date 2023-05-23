class Solution {
    public int deleteAndEarn(int[] nums) {
            // combine same number
            int [] combined = new int[10001]; // due to range of nums[i] in 10001
            for (int num :nums){
                    combined[num] += num;
            }

            // we have 2 decision at each step
            // first is skip second is take the num
            int prevTake = 0;
            int prevSkip = 0;
            // so store maxium prev take nums and prev skip nums

            for (int i = 0; i < combined.length;i++){
                int take = combined[i] + prevSkip; // if you want to take this current num
                // then you have to take this num and prevSkip num 
                //
                int skip = Math.max(prevSkip, prevTake); // but if you want to skip this current num
                // so skip value will be your max between prevskip and prevtake
                // mean that update your skip value latest
                // now store these current take and skip value into prevSkip, prevtake
                // => update new value
                prevTake = take;
                prevSkip = skip;
            }
            return Math.max(prevTake, prevSkip);

    }
}