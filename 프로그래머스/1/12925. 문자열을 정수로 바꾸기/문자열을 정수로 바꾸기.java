class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean flag = s.charAt(0) != '-';
        int idx = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;
        for (; idx < s.length(); idx++) {
            answer = answer * 10 + s.charAt(idx) - '0';
        }
        return answer * (flag ? 1 : -1);
    }
}
