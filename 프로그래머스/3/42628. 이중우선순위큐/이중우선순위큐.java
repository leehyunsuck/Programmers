import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String o : operations) {
            String[] split = o.split(" ");
            int num = Integer.parseInt(split[1]);
            
            switch (split[0]) {
                case "I":
                    minQueue.offer(num);
                    maxQueue.offer(num);
                    break;
                case "D":
                    if (minQueue.isEmpty()) continue;
                    if (num == -1) maxQueue.remove(minQueue.poll());
                    else minQueue.remove(maxQueue.poll());
                    break;
            }
        }
        
        if (minQueue.isEmpty()) return new int[2];
        return new int[] {maxQueue.poll(), minQueue.poll()};
    }
}