class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] poss = { "aya", "ye", "woo", "ma" };
        String[] imposs = new String[poss.length];
        for (int i = 0; i < poss.length; i++) imposs[i] = poss[i] + poss[i];
        
        for (String word : babbling) {
            String temp = word;
            for (String no : imposs) temp = temp.replaceAll(no, "");
            if (temp.length() == word.length()) {
                for (String yes : poss) word = word.replaceAll(yes, " ");
                answer += word.isBlank() ? 1 : 0;
            }
        }

        return answer;
    }
}

// 연속은 발음 불가능