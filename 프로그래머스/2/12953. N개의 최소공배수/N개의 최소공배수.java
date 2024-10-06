class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        for (int tempAnswer = 1; answer == 0; tempAnswer++) {
            boolean pass = true;
            
            for (int num : arr) {
                if (tempAnswer % num != 0) pass = false;
                if (!pass) break;
            }
            
            if (pass) answer = tempAnswer;
        }
        
        return answer;
    }
}

