import java.util.*;

class Solution {
    private static final int[] DISCOUNT_RATES = new int[] {10, 20, 30, 40};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        // BFS (그냥 편해서 쓴거임)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[emoticons.length + 1]);
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int idx = poll[poll.length - 1];
            
            if (idx == poll.length - 1) {
                int[] result = calSell(users, emoticons, poll);
                if (isMore(answer, result)) {
                    answer = result;
                }
                continue;
            }
            
            poll[poll.length - 1]++;
            
            for (int discount : DISCOUNT_RATES) {
                int[] copyPoll = Arrays.copyOf(poll, poll.length);
                copyPoll[idx] = discount;
                
                queue.offer(copyPoll);
            }
        }
        
        return answer;
    }
    
    // 목표에 맞는지 확인
    public boolean isMore(int[] target, int[] newTarget) {
        if (target[0] > newTarget[0]) return false;
        if (target[0] == newTarget[0] && target[1] > newTarget[1]) return false;
        
        return true;
    }
    
    // 할인율에 맞게 계산후 return 플러스가입자, 이모티콘판매액 
    public int[] calSell(int[][] users, int[] emoticons, int[] discounts) {
        int[] result = new int[2];
        
        for (int[] user : users) {
            int sell = 0;
            
            for (int idx = 0; idx < emoticons.length; idx++) {
                if (discounts[idx] < user[0]) continue;
                
                sell +=emoticons[idx] * ((100 - discounts[idx]) / 100.0);
            }
            
            if (sell >= user[1]) result[0]++;
            else result[1] += sell;
        }
        
        return result;
    }
}
