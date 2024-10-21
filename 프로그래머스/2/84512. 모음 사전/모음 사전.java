class Solution {
    private static char[] chars = {'A', 'E', 'I', 'O', 'U'};
    
    private String correctAnswer;
    private int count;
    
    public void setCorrectAnswer(String answer) {
        this.correctAnswer = answer;
        this.count = 0;
    }

    public void addCount() {
        this.count += 1;
    }
    
    public int solution(String word) {
        this.setCorrectAnswer(word);
        
        return countGenerateWords("");
    }
    
    public int countGenerateWords(String word) {
        if (word.length() > 0) {
            this.addCount();
            if (word.equals(this.correctAnswer))
                return this.count;
        }
        
        if (word.length() < 5) {
            for (char c : chars) {
                int getReturnValue = countGenerateWords(word + c);
                if (getReturnValue != -1)
                    return getReturnValue;
            }
        }
        
        return -1;
    }
}