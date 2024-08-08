import java.util.*;

class Solution {

    public int[] solution(String[] park, String[] routes) {
        
        int[] max = {park.length - 1, park[0].length() - 1};
        
        int[] answer = {0, 0};
        
        // 현재 로봇 강아지 위치
        for (int r = 0; r < park.length; r++) {
            int c = park[r].indexOf("S");  
            if (c != -1) {
                answer = new int[]{ r, c };
                break;
            }
        }

        Map<Character, int[]> moveMap = new HashMap<>() {{
            put('E', new int[] {0, 1});
            put('W', new int[] {0, -1});
            put('S', new int[] {1, 0});
            put('N', new int[] {-1, 0});
        }};

        for (String route : routes) {
            
            String[] rSplit = route.split(" ");
            Character direction = rSplit[0].charAt(0);
            int space = Integer.parseInt(rSplit[1]);
            

            int[] mapGet = moveMap.get(direction);  // 이동할 칸
            int[] temp = answer;                    // 임시로 위치 저장
            boolean check = true; 
            
            for (int i = 0; i < space && check; i++) {
                // 다음 위치값
                int[] nextL = {temp[0] + mapGet[0], temp[1] + mapGet[1]};
                // 벽 넘는지 확인
                if (nextL[0] > max[0] || nextL[0] < 0 || nextL[1] > max[1] || nextL[1] < 0) check = false;
                // 장애물 확인
                else if (park[nextL[0]].charAt(nextL[1]) == 'X') check = false;
                // 통과시 임시 위치값 = 확인한 다음 위치 값 저장
                else temp = nextL;
            }
            if (check) answer = temp;
        }
        
        return answer;
    }
}
