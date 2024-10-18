import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] location = {0, 0};
        Set<String> tempSet = new HashSet<>();
        
        for (char c : dirs.toCharArray()) {
            int[] temp = Arrays.copyOf(location, location.length);
            switch (c) {
                case 'U':
                    location[1]++;
                    if (location[1] > 5) location[1]--;
                    break;
                case 'D':
                    location[1]--;
                    if (location[1] < -5) location[1]++;
                    break;
                case 'L':
                    location[0]++;
                    if (location[0] > 5) location[0]--;
                    break;
                case 'R':
                    location[0]--;
                    if (location[0] < -5) location[0]++;
                    break;
                default:
                    break;
            }
            
            String add = "";
            if (location[0] == temp[0] && location[1] == temp[1]) continue;
            if (location[0] != temp[0]) {
                //x 움직임
                add = location[0] < temp[0] 
                    ? "x" + location[0] + temp[0] + "y" + location[1] + temp[1]
                    : "x" + temp[0] + location[0] + "y" + temp[1] + location[1];
            } else {
                //y 움직임
                add = location[1] < temp[1] 
                    ? "x" + location[0] + temp[0] + "y" + location[1] + temp[1] 
                    : "x" + temp[0] + location[0] + "y" + temp[1] + location[1];
            }
            tempSet.add(add);
        }
        
        return tempSet.size();
    }
}