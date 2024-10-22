class Solution {
    public boolean solution(int x) {
        int sum = 0,
            copyX = x;
        while (copyX > 0) {
            sum += copyX % 10;
            copyX /= 10;
        }
        return x % sum == 0;
    }
}

// n의 자리수 합으로 n의 나머지가 0이면 true