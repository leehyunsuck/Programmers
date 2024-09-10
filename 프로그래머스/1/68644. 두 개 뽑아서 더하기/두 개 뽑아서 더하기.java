import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) 
            for (int j = i + 1; j < numbers.length; j++) 
                if (!answer.contains(numbers[i]+numbers[j])) answer.add(numbers[i] + numbers[j]);

        Collections.sort(answer);
        
        int[] returnAnswer = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) returnAnswer[i] = answer.get(i);
            
        return returnAnswer;
    }
}