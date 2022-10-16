class Solution {
    public int[][] merge(int[][] intervals) {
      if(intervals.length < 1)  {
          return intervals;
      }
        
        Arrays.sort(intervals,(i1,i2)-> Integer.compare(i1[0],i2[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] nextInterval = intervals[0];
        result.add(nextInterval);
        
        for(int[] interval: intervals){
            if(interval[0] <= nextInterval[1]){
                nextInterval[1] = Math.max(interval[1], nextInterval[1]);
            }
            else{
                  nextInterval = interval; 
                result.add(nextInterval);
              
            }
        }
        
        return result.toArray(new int [result.size()][]);
        
    }
}