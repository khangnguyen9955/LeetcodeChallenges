class Solution {
    
    public  List<String> generateParenthesis(int n) {
                List<String> list = new ArrayList<>();
                backtracking(list,"",0,0,n);
                return list;
                // base case N*2 la se return ra cai solution do
                // vi du n = 3 => co 3 () thi str.length == 6 thi se tra ra solution do
    }

    public  void backtracking (List<String> list, String s, int open, int close, int max){
// max se la n*2
        if(s.length() == max*2){
            list.add(s);
            // du length roi thi add zo roi return thoi chu doi gi ??
            return;
        }

        // open la cu mo ngoac ( nen phai check no khi no mo 3 cai roi thi no ko con nho hon max nua nen phai chuyen qua close thoi
        if(open < max){
            // cho nay minh backtrack cho no mo ngoac nen open+1 , vi no mo thi open se tang len 1 cai ngoac mo
            backtracking(list,s+"(",open+1,close,max );
        }
        // co nghia la dong ngoac lai cho du cai ngoac da mo? nen phai check xem no co nho hon so ngoac open ko
        // vi du da open 3 cai thi close lai 3 cai
        if(close<open){
            // cho nay minh backtrack cho no dong ngoac nen close +1 , vi no dong thi close se tang len 1 cai ngoac dong
            backtracking(list,s+")",open,close+1,max);
        }






    }

}