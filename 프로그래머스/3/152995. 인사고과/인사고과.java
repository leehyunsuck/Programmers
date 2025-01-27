import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanhoScore = scores[0];

        Arrays.sort(scores, (a1, a2) -> {
            if (a1[0] != a2[0]) return a2[0] - a1[0];   // 첫번째 내림
            return a1[1] - a2[1];                       // 같다면 두번쨰 올림
        });
        
        /*
        for (int[] score : scores)
            System.out.println(Arrays.toString(score));
        */

        int maxSecond = 0;

        for (int[] score : scores) {
            // 인센티브 못받음
            if (score[1] < maxSecond) {
                if (score == wanhoScore) return -1;
                continue;
            }
            maxSecond = score[1];

            // 완호 등수 밀려남
            if (score[0] + score[1] > wanhoScore[0] + wanhoScore[1]) 
                answer++;
        }

        return answer;
    }
}
