import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length};
        int sum = 0, left = 0;
    
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            while (sum > k && left <= right) sum -= sequence[left++];   
            if (sum == k && right - left < answer[1] - answer[0]) answer = new int[] {left, right};
        }
        
        return answer; 
    }
}

/*
오름차순으로 정렬된 수열이 주어짐

[Q] 특정 조건을 만족하는 부분 수열 찾기

Index X ~ Y 의 합 = K

X ~ Y 가 여러개 ?
    -> 길이가 짧은 것
    
길이가 짧은 X ~ Y 가 여러개 ?
    -> 앞쪽에 나오는 == 인덱스 번호가 더 작은

*/