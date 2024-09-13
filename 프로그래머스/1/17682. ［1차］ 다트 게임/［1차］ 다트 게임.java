class Solution {
    public int solution(String dartResult) {

        char[] results = dartResult.toCharArray();
        
        int count = 0;
        for (char c : results)
            if (c == 'S' || c == 'D' || c == 'T') count++;
        
        int[] scores = new int[count];
        
        for (int i = 0, j = 0; i < results.length - 1; i += 2, j++) {
            int score = results[i+1] == '0' ? 10 : results[i] - '0';
            if (score == 10) i++;
            int bonus = switch(results[i+1]) {
                    case 'S' -> 1;
                    case 'D' -> 2;
                    case 'T' -> 3;
                    default -> 1;
            };
            char option = 'N';
            if (i+2 < results.length && results[i+2] <= '*') option = results[++i+1];
            scores[j] = (int) Math.pow(score, bonus);  
 
            if (option == '*') {
                scores[j] *= 2;
                if (j > 0) scores[j-1] *= 2;
            }
            else if (option == '#') scores[j] *= -1;
        }
        
        int answer = 0;
        for (int score : scores) answer += score;
        
        return answer;
    }
}

// 3번의 기회 (각 기회마다 0~10점)
// 영역별 추가 계산 S(1) D(2) T(3) 제곱
// 옵션 추가 계산 *(해당 라운드, 전 라운드 점수를 2배로) #(해당 점수 마이너스로)
