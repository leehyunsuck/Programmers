import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        Map<Long, Long> nextRoomMap = new HashMap<>();
        
        for (int idx = 0; idx < room_number.length; idx++) {
            long roomNum = room_number[idx];
            
            List<Long> visited = new ArrayList<>();
            while (nextRoomMap.containsKey(roomNum)) {
                visited.add(roomNum);
                roomNum = nextRoomMap.get(roomNum);
            }
            
            answer[idx] = roomNum;
            
            nextRoomMap.put(roomNum, roomNum + 1);
            for (long visit : visited)
                nextRoomMap.put(visit, roomNum + 1);
        }
        
        return answer;
    }
}
