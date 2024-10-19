import java.util.*;

class Solution {
    public boolean isNowRank(int[] rankArr, int rank) {
        for (int idx = rank + 1; idx < rankArr.length; idx++) {
            if (rankArr[idx] <= 0) continue;
            return false;
        }
        return true;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> processQ = new LinkedList<>();
        int[] rankArr = new int[10];
        
        for (int pri : priorities) {
            rankArr[pri]++;
            processQ.add(pri);
        }
        
        while (!processQ.isEmpty()) {
            int rank = processQ.remove();
            rankArr[rank]--;

            if (this.isNowRank(rankArr, rank)) {
                answer++;
                if (location == 0) return answer;
            } else {
                processQ.add(rank);
                rankArr[rank]++;
            }
            
            location = location - 1 >= 0 ? location - 1 : processQ.size() - 1;
        }

        return answer;
    }
}