import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        // 정렬되어있으니 k와 같은 요소가 인덱스에 있으면 return
        int idx = Arrays.binarySearch(sequence, k);
        if (idx >= 0) {
            while (idx != 0 && sequence[idx] == sequence[idx-1]) idx--;
            return new int[] {idx, idx};
        }
        
        // 없으면 찾기
        int[] answer = null;
        int left = 0,
            sum = 0,
            saveLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while (sum > k && left < right) sum -= sequence[left++];
            
            if (sum == k && saveLen > right - left) {
                saveLen = right - left;
                answer = new int[] {left, right};
            }
            
        }
        
        return answer;
    }
}

/*
10 ~ 시간초과

        int[]   answer = {-1, -1},
                tempSave = {0, 0};
        
        int sum = 0;
        for (int i = 0; i < sequence.length && sequence[i] <= k; i++) {
            sum += sequence[i];
            
            while (sum > k) {
                sum = 0;
                tempSave[0]++;
                for (int j = tempSave[0]; j <= i; j++) sum += sequence[j];
            }
            
            if (sum == k) {
                sum = 0;
                tempSave[1] = i;
                if (answer[0] == -1 || answer[1] - answer[0] > tempSave[1] - tempSave[0]) {
                    answer[0] = tempSave[0];
                    answer[1] = tempSave[1];
                }
                tempSave[0]++;
                for (int j = tempSave[0]; j <= i; j++) sum += sequence[j];
            }
        }
        
        return answer;

*/


/*
더 오래걸림


        int idx = Arrays.binarySearch(sequence, k);
        if (idx >= 0) {
            while (idx != 0 && sequence[idx] == sequence[idx-1]) idx--;
            return new int[] {idx, idx};
        }
   
        for (int i = 1; i < sequence.length; i++) {
            for (int j = 0; j < sequence.length - i; j++) {
                if (sequence[j] > k) break;
                int num = 0;
                for (int l = j; l <= j + i; l++) num += sequence[l];
                if (num == k) return new int[] {j, j+i};
            }
        }
        return new int[2];
*/