class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] poss = { "aya", "ye", "woo", "ma" };
        
        for (String word : babbling) {
            for (String p : poss) {
                if (word.contains(p+p)) continue;
                word = word.replaceAll(p, " ");
            }
            answer += word.isBlank() ? 1 : 0;
        }

        return answer;
    }
}

// 연속은 발음 불가능