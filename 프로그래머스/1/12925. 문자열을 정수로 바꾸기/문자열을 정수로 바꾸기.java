class Solution {
    public int solution(String s) {
        //return Integer.parseInt(s);
        
        int answer = 0;
        boolean minus = false;
        
        for (char c : s.toCharArray()) {
            if (c < '0') {
                minus = c == '-';
                continue;
            }
            answer = answer * 10 + c - '0';
        }
        
        return minus ? answer * -1 : answer;
    }
}