class Solution {
    public String solution(String s) {
        char[] answer = s.toCharArray();
        sortChar(answer);
        
        return String.valueOf(answer);
    }
    
    public void sortChar(char[] arr) {
        for (int firstIdx = 0; firstIdx < arr.length; firstIdx++) {
            int minIdx = firstIdx;
            
            for (int findIdx = firstIdx + 1; findIdx < arr.length; findIdx++)
                if (arr[minIdx] < arr[findIdx]) minIdx = findIdx;
            
            if (minIdx == firstIdx) continue;
            
            char temp = arr[firstIdx];
            arr[firstIdx] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}