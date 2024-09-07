import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] lank = {6, 6, 5, 4, 3, 2, 1};
        
        Map<Integer, Boolean> saveNum = new HashMap<>();
        for (int winNum : win_nums) saveNum.put(winNum, true);
        
        int zeroCount = 0,
            correctCount = 0;
        
        for (int lotto : lottos) {
            if (saveNum.containsKey(lotto)) correctCount++;
            else if (lotto == 0) zeroCount++;
        }

        return new int[] {lank[zeroCount + correctCount], lank[correctCount]};
    }
}

// 최고 등수, 최저 등수