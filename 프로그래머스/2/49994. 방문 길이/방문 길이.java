import java.util.*;

class Solution {
    
    private int[] location = {0, 0};
    
    public int solution(String dirs) {
        Map<Character, Integer[]> moveMap = new HashMap<>() {{
            put('U', new Integer[] {0, 1});
            put('D', new Integer[] {0, -1});
            put('R', new Integer[] {1, 0});
            put('L', new Integer[] {-1, 0});
        }};
        
        Set<String> tempSet = new HashSet<>();
        
        for (char c : dirs.toCharArray()) {
            Integer[] moveInfo = moveMap.get(c);
            int[] temp = Arrays.copyOf(location, location.length);
            
            location[0] += moveInfo[0];
            location[1] += moveInfo[1];
            
            if (this.mapOver(moveInfo)) continue;
            
            String add = null;
            if (location[0] != temp[0]) {
                add = location[0] < temp[0] 
                    ? "" + location[0] + temp[0] + location[1] + temp[1]
                    : "" + temp[0] + location[0] + temp[1] + location[1];
            } else {
                add = location[1] < temp[1] 
                    ? "" + location[0] + temp[0] + location[1] + temp[1] 
                    : "" + temp[0] + location[0] + temp[1] + location[1];
            }
            tempSet.add(add);
        }
        
        return tempSet.size();
    }
    
    // 넘어가서 제자리인 경우 true 반환
    public boolean mapOver(Integer[] moveInfo) {
        if (location[0] > 5 || location[0] < -5) location[0] -= moveInfo[0];
        else if (location[1] > 5 || location[1] < -5) location[1] -= moveInfo[1];
        else return false;
        return true;
    }
}