import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        this.clearDict(dict);
        
        List<Integer> answerList = new ArrayList<>();        
        this.lzw(dict, answerList, msg);

        int[] answer = this.listToArr(answerList);
        return answer;
    }
    
    public void clearDict(Map<String, Integer> dict) {
        char start = 'A';
        
        for (int i =1; i < 'Z' - 'A' + 2; i++)
            dict.put("" + start++, i);
    }
    
    public int[] listToArr(List<Integer> list) {
        int[] result = new int[list.size()];
        
        int idx = 0;
        for (int value : list)
            result[idx++] = value;
        
        return result;
    }
    
    public void lzw(Map<String, Integer> dict, List<Integer> answerList, String msg) {
        int lastNum = dict.size() + 1;
        
        StringBuilder str = new StringBuilder();
        for (char c : msg.toCharArray()) {
            str.append(c);
            if (dict.containsKey(str.toString())) continue;
            
            String key = str.toString().substring(0, str.length() - 1);
            answerList.add(dict.get(key));
            dict.put(str.toString(), lastNum++);

            str = new StringBuilder();
            str.append(c);
        }
        
        if (str.length() != 0) {
            if (dict.containsKey(str.toString())) 
                answerList.add(dict.get(str.toString()));
            else {
                String  lastStr = str.toString().substring(0, str.length() - 1),
                        lastChar = str.toString().substring(str.length());
                
                answerList.add(dict.get(lastStr));
                answerList.add(dict.get(lastChar));
            }
        }
    }
}