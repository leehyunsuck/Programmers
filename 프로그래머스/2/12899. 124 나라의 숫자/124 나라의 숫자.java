class Solution {
    public String solution(int n) {
        int[] country124 = {4, 1, 2};
        
        StringBuilder answer = new StringBuilder();
        
        while (n > 0) {
            int value = n % 3;
            if (value == 0) n--;
            answer.append(country124[value]);
            n /= 3;
        }
        answer.reverse();
        
        return answer.toString();
    }
}