// 문제 진짜 문제있네

// birdge_length는 다리의 길이이고, 1초에 1 만큼 움직일 수 있다.
// 또한 트럭은 다리의 길이만큼 올라갈 수 있다.

import java.util.*;

class Solution {
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