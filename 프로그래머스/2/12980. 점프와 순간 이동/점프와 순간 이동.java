public class Solution {
    public int solution(int n) {
        int answer = 0;
        for (; n > 0; n--) {
            if (n % 2 == 0) n = n / 2 + 1;
            else answer++;
        }
        return answer;
    }
}