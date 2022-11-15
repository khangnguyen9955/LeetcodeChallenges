class Solution {
public:
    int reverse(int x) {
    long temp =0;
    long pos = 0;
    long result= 0;
        while (x!=0){
        pos = x % 10;           
        x/=10;
       if (temp > INT_MAX/10 || (temp == INT_MAX / 10 && pos > 7)) return 0;
            if (temp < INT_MIN/10 || (temp == INT_MIN / 10 && pos < -8)) return 0;
        temp = result * 10 + pos;
        result = temp;
        }
         return result;
    }
};