class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int idx = 0; idx < s.length(); idx++)
            answer = max(answer, sameCharAtLen(s, idx, idx), sameCharAtLen(s, idx, idx + 1));

        return answer;
    }
    
    public int sameCharAtLen(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) break;
            left--;
            right++;
        }
        
        return right - left - 1;
    }
    
    public int max(int one, int two, int three) {
        int result = one;
        if (two > result)   result = two;
        if (three > result) result = three;
        
        return result;
    }
}