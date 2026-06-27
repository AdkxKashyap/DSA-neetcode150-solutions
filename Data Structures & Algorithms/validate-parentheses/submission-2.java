class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') stk.push(ch);
            else {
                if(stk.isEmpty()) return false;
                if(ch == ')' && stk.peek() == '(') stk.pop();
                else if(ch == '}' && stk.peek() == '{') stk.pop();
                else if(ch == ']' && stk.peek() == '[') stk.pop();
                else return false;
            }
        }
        return stk.isEmpty() && true;
    }
}
