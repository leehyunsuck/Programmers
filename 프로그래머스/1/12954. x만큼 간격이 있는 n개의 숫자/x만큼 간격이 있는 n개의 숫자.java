class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long xLong = (long) x;
        for (int i = 1; i <= n; i++) answer[i-1] = xLong * i;
        return answer;
    }
}