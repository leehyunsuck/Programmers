import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int temp = storey % 10;
            storey /= 10;
            
            switch (temp) {
                case 0: case 1: case 2: case 3: case 4: // temp < 5
                    answer += temp;
                    break;
                case 6: case 7: case 8: case 9: // temp > 5
                    answer += 10 - temp;
                    storey++;
                    break;
                default:                        // temp == 5
                    answer += 5;
                    if (storey % 10 >= 5) storey++;
                    break;
            }
        }
        
        return answer;
    }
}