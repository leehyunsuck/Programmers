class Solution {
    
    private static char[] availableAlphabets = {'A', 'E', 'I', 'O', 'U'};

    private String findWord;
    private int counter;
    private int maxLen;
    
    public void setFindWord(String word) {
        this.findWord = word;
        this.counter = 0;
    }
    
    public void setMaxLen(int len) {
        this.maxLen = len;
    }
    
    public void addCounter() {
        this.counter++;
    }
    
    public boolean isWordsExist(String word) {
        if (word.length() > 0) {
            this.addCounter();
            if (word.equals(this.findWord)) return true;
        }
        
        if (word.length() < maxLen) {
            for (char c : availableAlphabets) {
                if (this.isWordsExist(word + c)) return true;
            }
        }
        
        return false;
    }
    
    public int solution(String word) {
        this.setFindWord(word);
        this.setMaxLen(5);
        
        int answer = -1;
        String startWord = "";
        
        if (isWordsExist(startWord)) answer = this.counter;
        
        return answer;
    }
}