import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        Queue<Integer> priQueue = new PriorityQueue<>();
        for (int s : scoville)
            priQueue.add(s);

        int answer = 0;
        for (; priQueue.size() >= 2 && priQueue.peek() < k; answer++)
            priQueue.add(priQueue.remove() + priQueue.remove() * 2);
        
        return priQueue.peek() >= k ? answer : -1;
    }
}