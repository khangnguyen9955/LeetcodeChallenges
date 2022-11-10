class Solution {
    public int mySqrt(int x) {
    int lo = 1;
    int hi = x;
        int mid = 0;
        if (x == 1){
            return 1;
        }
        if( x == 0){
            return 0;
        }
          while(true){
            mid = (lo+hi)/2;
            if (mid > x/mid) {
                hi = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                lo = mid + 1;
            }
        }
    
    }
}