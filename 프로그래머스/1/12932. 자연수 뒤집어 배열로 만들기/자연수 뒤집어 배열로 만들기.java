class Solution {
    public int[] solution(long n) {
        
        String strN = String.valueOf(n);
        int len = strN.length();
        
        int[] answer = new int[len];
        int idx = len - 1;
        for (char c : strN.toCharArray()) {
            answer[idx--] = c - '0';
        }
        
        return answer;
    }
}