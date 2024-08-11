class Solution {
    public int[] solution(String[] wallpaper) {
        
        //r최소, y최소, r최대, y최대 -> 비교하면서 줄여나가기 위해 최대값으로 설정
        int[] answer = {wallpaper.length, wallpaper[0].length(), 0, 0};
        
        for (int i = 0; i < wallpaper.length; i++) {
            if (!wallpaper[i].contains("#")) continue;
            
            answer[0] = Math.min(answer[0], i);
            answer[1] = Math.min(answer[1], wallpaper[i].indexOf("#"));
            
            answer[2] = Math.max(answer[2], i + 1);
            answer[3] = Math.max(answer[3], wallpaper[i].lastIndexOf("#") + 1);
        }
     
        return answer;
    }
}

/*
wallpaper 안에 모든 파일을 드래그하는 최소 좌표
r, c , r2, c2


r 0 : c 0 ~ wallpaper.length : wallpaper[0].length 

*/