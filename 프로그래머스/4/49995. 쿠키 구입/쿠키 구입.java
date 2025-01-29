import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0,
            len    = cookie.length;
        
        for (int m = 0; m < len - 1; m++) {
            int l = m,      // 첫째는 l ~ m까지
                r = m + 1;  // 둘째는 m+1 ~ r까지
            
            int firstChildSum  = cookie[l],
                secondChildSum = cookie[r]; 
            while (l >= 0 && r < len) {
                if (firstChildSum == secondChildSum)
                    answer = Math.max(answer, firstChildSum);
                
                if (firstChildSum <= secondChildSum && l > 0) // 크거나 작고는 여기 아니면 아래 조건문 어디든 한군데에만
                    firstChildSum += cookie[--l];
                else if (firstChildSum > secondChildSum && r < len - 1) 
                    secondChildSum += cookie[++r];
                else break; // 더이상 확장 불가능한 경우임
            }
        }
        
        return answer;
    }
}