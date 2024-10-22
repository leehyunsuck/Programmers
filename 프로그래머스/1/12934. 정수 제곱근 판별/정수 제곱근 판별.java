class Solution {
    public long solution(long n) {
        
        for (long i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return (i + 1) * (i + 1);
            }
        }
        
        return -1;
    }
}

/*

        double nSqrt = Math.sqrt(n);
        if (nSqrt == (long) nSqrt) {
            return (long) Math.pow(nSqrt + 1, 2);
        }
        
        return -1;

*/