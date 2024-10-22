class Solution {
    public int[] solution(long n) {
        String nToString = String.valueOf(n);
        
        int[] answer = new int[nToString.length()];
        
        int index = answer.length - 1;
        for (char c : nToString.toCharArray()) {
            answer[index--] = c - '0';
        }
        
        return answer;
    }
}