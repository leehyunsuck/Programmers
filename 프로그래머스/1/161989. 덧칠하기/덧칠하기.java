class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int temp = 0;
        for (int i : section) {
            if (i > temp) temp = 0;     // 칠해진 부분 아님
            if (temp == 0) {            // 칠하기
                temp = i + m - 1;
                answer++;
            }  
            if (i < temp) continue;     // 이미 칠해짐
        }
        
        return answer;
    }
}
