import java.util.*;

class Solution {        // bridge_length 대수 까지 가능, weight 이하 무개까지 가능, 
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = 0;
        
        int sumTruckWeight = 0;
        Queue<Integer> bridgeInSec = new LinkedList<>();
        Queue<Integer> truckWeight = new LinkedList<>();
        
        int idx = 0;
        while (idx == 0 || !bridgeInSec.isEmpty()) {
            second++;
            
            // Bridge Exit
            if (!bridgeInSec.isEmpty() && second - bridgeInSec.peek() >= bridge_length) {
                bridgeInSec.remove();
                sumTruckWeight -= truckWeight.remove();
            }
            
            // Bridge Entry
            if (idx < truck_weights.length && 
                bridgeInSec.size() < bridge_length && 
                sumTruckWeight + truck_weights[idx] <= weight) 
            {
                bridgeInSec.add(second);
                    truckWeight.add(truck_weights[idx]);
                    sumTruckWeight += truck_weights[idx++];
            }
        }
        
        return second;
    }
}