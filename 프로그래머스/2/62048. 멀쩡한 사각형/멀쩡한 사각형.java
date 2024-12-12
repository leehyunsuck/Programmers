import java.math.*;

class Solution {
    public long solution(int w, int h) {
        BigInteger bigW = BigInteger.valueOf(w),
                   bigH = BigInteger.valueOf(h);
        
        BigInteger add = bigW.add(bigH),
                   multi = bigW.multiply(bigH),
                   gcd = bigW.gcd(bigH);
        
        return multi.subtract(add.subtract(gcd)).longValue();
    }
}