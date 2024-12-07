import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // 정의 [2] 
        Arrays.sort(data, (arr1, arr2) -> {
            
            if (arr1[col - 1] != arr2[col - 1])     // col 기준으로 오름차순
                return arr1[col - 1] - arr2[col - 1];
            return arr2[0] - arr1[0];               // col 같으면 기본키 기준으로 내림차순
        });
        
        int answer = 0;
        
        // 정의 [4]
        for (int idx = row_begin - 1; idx < row_end; idx++) {
            int tuple = idx + 1;                
            
            // 정의 [3]
            int sum = 0;
            for (int column = 0; column < data[idx].length; column++)
                sum += data[idx][column] % tuple;
            
            answer ^= sum;
        }
        
        return answer;
    }
}