class Solution {
    public int[] solution(int[] arr) {
        // 값 1개만 있으면 -1 반환
        if (arr.length == 1)
            return new int[] {-1};
        
        // 최소값 인덱스번호 탐색
        int minIdx = 0;
        for (int idx = 0; idx < arr.length; idx++)
            if (arr[idx] < arr[minIdx]) minIdx = idx;
        
        // 최소값 인덱스 외 전부 복사
        int[] answer = new int[arr.length - 1];
        for (int idx = 0, answerIdx = 0; idx < arr.length; idx++, answerIdx++) {
            if (idx == minIdx) {
                answerIdx--;
                continue;
            }
            answer[answerIdx] = arr[idx];
        }
        
        return answer;
    }
}

// 방법1. 정렬 후 1번 인덱스부터 복사
// 방법2. 한번 쭉 탐색하고, 가장 작은 인덱스값 제외하고 복사