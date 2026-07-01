class Solution {
    public boolean isPalindrome(String s) {
        int slen = s.length();
        int i = 0; 
        int j = slen-1;
        while(i < j) {
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));
            boolean isLeftLetterOrDigit = left >= 'a' && left <= 'z' || (left >= '0' && left <= '9');
            boolean isRightLetterOrDigit = right >= 'a' && right <= 'z' || (right >= '0' && right <= '9');
            if(!isLeftLetterOrDigit) i++;
            else if(!isRightLetterOrDigit) j--;
            else {
                if(left != right) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}
