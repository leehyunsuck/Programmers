class Solution {
    public int solution(int[] sides) {
        int answer = 0,
            arrMax = Math.max(sides[0], sides[1]),
            arrMin = Math.min(sides[0], sides[1]);
        
        // 3 , 6 -> 6 < 3 + 4 5 6
        for (int i = arrMax - arrMin + 1; i <= arrMax && arrMin + i > arrMax; i++)  answer++;
        for (int i = arrMax + 1; i < arrMax + arrMin; i++)                          answer++;
        
        return answer;
    }
}

// maxLen < aLen + bLen