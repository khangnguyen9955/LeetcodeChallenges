class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int len = s.length();
        int index= 0;
        StringBuilder str = new StringBuilder();
        for (String a : s.trim().split(" ")) {
            if (!a.isEmpty())
                stack.push(a);
        }
        while(!stack.isEmpty()) {
            str.append(stack.pop());
            str.append(" ");
        }
        str.deleteCharAt(str.length()-1);

            return str.toString();
    }
}