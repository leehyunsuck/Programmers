class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] temp = new int[arr.length];
        
        int idx = 0;
        for (int a : arr) {
            if (a % divisor == 0) 
                temp[idx++] = a;
        }
        
        if (idx == 0)
            return new int[] {-1};
        
        int[] answer = new int[idx];
        for (int i = 0; i < idx; i++)
            answer[i] = temp[i];
        
        this.sort(answer);
        
        return answer;
    }
    
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallIdx = i;
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallIdx])
                    smallIdx = j;
            }
            
            if (smallIdx == i) continue;
            int big = arr[i];
            arr[i] = arr[smallIdx];
            arr[smallIdx] = big;
        }
        
        return arr;
    }
}