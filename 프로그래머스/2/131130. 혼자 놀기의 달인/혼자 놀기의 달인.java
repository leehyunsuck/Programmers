import java.util.*;

class Solution {
    public int solution(int[] cards) {
        List<Integer> list = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == -1) continue;
            
            int visitCount = getVisitCount(cards, i);
            total += visitCount;
            list.add(visitCount);
            
            if (total == cards.length) break;
        }
        list.sort(Collections.reverseOrder());

        return list.size() == 1 ? 0 : list.get(0) * list.get(1);
    }
    
    private int getVisitCount(int[] arr, int start) {
        int result = 0;
        
        int idx = start;
        while (arr[idx] != -1) {
            result++;
            int beforeUsed = arr[idx];
            arr[idx] = -1;
            idx = beforeUsed - 1; // arr 내부 값은 1base
        }
        
        return result;
    }
}