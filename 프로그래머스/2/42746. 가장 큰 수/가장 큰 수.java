import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b+a).compareTo(a+b))
                .forEach(answer::append);

        
        return answer.charAt(0) != '0' ? answer.toString() : "0";
    }
}