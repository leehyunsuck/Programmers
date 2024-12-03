import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // A카드를 모두 나눌 수 있고, B 카드를 하나도 나눌 수 없는 양의 정수
        // B카드를 모두 나눌 수 있고, A 카드를 하나도 나눌 수 없는 양의 정수
        // 중 가장 큰 값
        
        int answer = 0;
        
        List<Integer> aDivisor = new ArrayList<>(),
                      bDivisor = new ArrayList<>();
        
        divisorAdd(aDivisor, arrayA);
        divisorAdd(bDivisor, arrayB);
        
        for (int num : aDivisor) {
            if (!canDivide(arrayB, num)) {
                answer = num;
                break;
            }
        }
        
        for (int num : bDivisor) {
            if (num <= answer) break;
            if (!canDivide(arrayA, num)) {
                answer = num;
                break;
            }
        }
        
        return answer;
    }
    
    // arr에 모든 값중 하나라도 num으로 나누어 떨어지면 true
    public boolean canDivide(int[] arr, int num) {
        for (int a : arr) {
            if (a % num == 0) {
                return true;
            }
        }
        return false;
    }
    
    public void divisorAdd(List<Integer> list, int[] arr) {
        Arrays.sort(arr);
        
        for (int i = 2; i <= arr[0]; i++) {
            boolean can = true;
            for (int a : arr) {
                if (a % i != 0) {
                    can = false;
                    break;
                }
            }
            if (can) list.add(i);
        }
        
        Collections.sort(list, Comparator.reverseOrder());
    }
}