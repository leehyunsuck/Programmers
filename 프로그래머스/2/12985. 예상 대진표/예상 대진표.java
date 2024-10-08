class Solution {
    public int solution(int n, int a, int b) {
        for (int round = 0;; round++) {
            if (a == b) return round;
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
        }
    }
}