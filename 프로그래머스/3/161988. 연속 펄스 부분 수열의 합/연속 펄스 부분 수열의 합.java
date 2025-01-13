class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        
        int[] plusStartPulse  = new int[len],   // 연속 펄스를 +1 부터 시작
              minusStartPulse = new int[len];   // (반대)     -1
        
        for (int idx = 0; idx < len; idx++) {
            plusStartPulse[idx]  = idx % 2 == 0 ? sequence[idx] : -1 * sequence[idx];
            minusStartPulse[idx] = -1 * plusStartPulse[idx];
        }
        
        return Math.max(maxPartSum(plusStartPulse), maxPartSum(minusStartPulse));
    }
    
    // 이건 부분 최대합 찾는 알고리즘
    // 만약 부분합이 가장 큰 시작과 끝의 인덱스를 구하라 한다면 어떻게 할지 생각해보시와요~ (응용하면 됩니당)
    private long maxPartSum(int[] arr) {
        long maxSum  = arr[0],
             partSum = arr[0];
        
        for (int idx = 1; idx < arr.length; idx++) {
            partSum = Math.max(arr[idx], partSum + arr[idx]);
            maxSum  = Math.max(maxSum, partSum);
        }
        
        return maxSum;
    }
}