class Solution {
  
    public  List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();

        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        backtracking2(list,digits.toCharArray(), "", dict);
        return list;
    }


    public  void backtracking2(List<String> list, char[] digits, String s , String [] dic){
            if(s.length()== digits.length){
                list.add(s);
                return;
            }
            int i = s.length(); // bien nay dung de lay nhung thang char tiep theo , vi du khi no length 0 thi lay nhung thang char trong digits[0]
        // khi da lay thang digits[0] roi thi bh minh se bdau lay nhung thang char cua digits[1]
        // khi lay het thang digits[1] ropi thi quay lai lay het nhugnb thang char con lai trong digits[0]
            int digit = digits[i] - '0';  //
        for (char letter : dic[digit].toCharArray()) {
            backtracking2(list, digits, s + Character.toString(letter), dic);
        }
    }





}