import java.util.*;

class Solution {
    
    public char clickFinger(int number) {
        return switch(number) {
                case 1, 4, 7 -> 'L';
                case 3, 6, 9 -> 'R';
                default -> 'C';
        };
    }
    
    public String solution(int[] numbers, String hand) {
        
        int[][] keypad = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 2}
        };
        
        int[][] fLocation = { keypad[10], keypad[11] };
        
        StringBuilder answer = new StringBuilder();
        for (int number : numbers) {
            char finger = this.clickFinger(number);
            
            if (finger == 'C') {
                int leftMove = Math.abs(fLocation[0][0] - keypad[number][0]) + Math.abs(fLocation[0][1] - keypad[number][1]);
                int rightMove = Math.abs(fLocation[1][0] - keypad[number][0]) + Math.abs(fLocation[1][1] - keypad[number][1]);

                if (leftMove < rightMove || (leftMove == rightMove && hand.equals("left"))) finger = 'L';
                else finger = 'R';
            }
            
            answer.append(finger);
            fLocation[finger == 'L' ? 0 : 1] = keypad[number];
        }
        
        return answer.toString();
    }
}