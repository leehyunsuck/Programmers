class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int minPeople = 1,
            maxPeople = getMaxValueInArr(stones);
        
        while (minPeople <= maxPeople) {
            int median = (minPeople + maxPeople) / 2;
            int linkedZeroCount = getLinkedZeroCountInArr(stones, median);
            
            if (linkedZeroCount < k) {
                answer = median;
                minPeople = median + 1;
                continue;
            }
            maxPeople = median - 1;
        }
        
        return answer;
    }
    
    private int getLinkedZeroCountInArr(int[] arr, int minus) {
        int result = 0;
        
        int temp = 0;
        for (int value : arr) {
            if (value - minus >= 0) {
                result = Math.max(result, temp);
                temp = 0;
                continue;
            }
            temp++;
        }
        
        return Math.max(result, temp);
    }
    
    private int getMaxValueInArr(int[] arr) {
        int result = 0;
        
        for (int value : arr)
            result = Math.max(result, value);
        
        return result;
    }
}