import java.math.*;

class Solution {
    public long solution(int w, int h) {
        return ((long) w * h) - (w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue());
    }
}