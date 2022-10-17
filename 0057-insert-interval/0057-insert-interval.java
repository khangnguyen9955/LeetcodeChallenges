class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> result = new LinkedList<>();
        int i = 0;
        
        
        // skill all the intervasl which ends before the start of the new interval
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        
        
        
        // merge the new interval with the algorithm 
        // c.start = min(a.start,b.start);
        // c.end = max(a.end,b,end);
        
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        
        // add the merged interval
        result.add(newInterval);
        
        // add all the rest interval
        while(i<intervals.length){
            result.add(intervals[i]);
            i++;
        }
        
        
        
        
        
        return result.toArray(new int [result.size()][]);
    }
}