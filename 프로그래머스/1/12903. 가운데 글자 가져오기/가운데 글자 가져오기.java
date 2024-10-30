class Solution {
    public String solution(String s) {
        int len2 = s.length() / 2;
        
        return  s.length() % 2 == 0 ? 
                s.substring(len2 - 1, len2 + 1) : 
                s.substring(len2    , len2 + 1) ;
    }
}