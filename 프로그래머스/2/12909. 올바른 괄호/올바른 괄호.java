import java.util.*;

class Solution {
    boolean solution(String s) {
        int[] check = new int[] {0, 0};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') check[0]++;
            else if (check[1] + 1 > check[0]) return false;
            else check[1]++;
        }
        
        return check[0] == check[1];
    }
}

/* 큐 이용
        Queue<Boolean> tempQueue = new LinkedList<>(); 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') tempQueue.add(true);
            else if (tempQueue.peek() != null) tempQueue.remove();
            else return false;
        }
        
        return tempQueue.peek() == null;
        
테스트 1 〉	통과 (0.10ms, 70.5MB)
테스트 2 〉	통과 (0.13ms, 77.3MB)
테스트 3 〉	통과 (0.10ms, 73.7MB)
테스트 4 〉	통과 (0.18ms, 73.7MB)
테스트 5 〉	통과 (0.12ms, 67.7MB)

*/

/* 배열 이용
    boolean solution(String s) {
        int[] check = new int[] {0, 0};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') check[0]++;
            else if (check[1] + 1 > check[0]) return false;
            else check[1]++;
        }
        
        return check[0] == check[1];
    }


테스트 1 〉	통과 (0.03ms, 72.2MB)
테스트 2 〉	통과 (0.03ms, 73MB)
테스트 3 〉	통과 (0.04ms, 77MB)
테스트 4 〉	통과 (0.02ms, 74MB)
테스트 5 〉	통과 (0.02ms, 72.3MB)
*/