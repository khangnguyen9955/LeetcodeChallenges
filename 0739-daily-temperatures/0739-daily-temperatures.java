class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ans = new int [temperatures.length];
        int hottest = 0;
        for(int i = temperatures.length-1 ; i >= 0;i--){
          int  currTemp = temperatures[i];
            if(currTemp >= hottest){
                hottest = currTemp;
                continue;
            }
        
            int days = 1;
            while(temperatures[i + days] <= currTemp){
                days += ans[i+days]  ; 
            }
            ans[i] = days;
        }
        return ans;
}
}