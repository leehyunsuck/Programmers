class Solution {
    public long solution(long n) {
        
        double nSqrt = Math.sqrt(n);
        if (nSqrt == (long) nSqrt) {
            return (long) Math.pow(nSqrt + 1, 2);
        }
        
        return -1;
    }
}