class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder thr = new StringBuilder();
        while (n > 0) {
            thr.append(n % 3);
            n /= 3;
        }
            
        for (int i = 0; i < thr.length(); i++) 
            answer += Math.pow(3, thr.length() - 1 - i) * (thr.charAt(i) - '0');
             
        return answer;
    }
}