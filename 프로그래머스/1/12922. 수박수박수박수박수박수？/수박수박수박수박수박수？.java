class Solution {
    public String solution(int n) {
        char[] datas = {'수', '박'};
        
        char[] answer = new char[n];
        for (int idx = 0; idx < answer.length; idx++)
            answer[idx] = datas[idx % 2];
        
        return String.valueOf(answer);
    }
}