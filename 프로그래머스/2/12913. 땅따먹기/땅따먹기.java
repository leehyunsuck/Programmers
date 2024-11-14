class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int row = 1; row < land.length; row++) {
            for (int column = 0; column < land[row].length; column++) {
                // 윗 줄 에서 가장 큰 값 더할거임 (같은 열 아닌 값들 중)
                int big = 0;
                for (int tCol = 0; tCol < land[row].length; tCol++) {
                    if (column == tCol) continue;               // 같은 열 ㅂㅂ
                    if (big > land[row - 1][tCol]) continue;    // big이 더 큼 ㅂㅂ
                    big = land[row-1][tCol];
                }
                land[row][column] += big;
            }
        }
        
        // 맨 마지막줄에서 가장 큰 값 찾기
        for (int i = 0; i < land[land.length - 1].length; i++) {
            if (answer > land[land.length - 1][i]) continue;
            answer = land[land.length - 1][i];
        }

        return answer;
    }
}