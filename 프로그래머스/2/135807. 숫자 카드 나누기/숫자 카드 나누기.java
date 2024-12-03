import java.util.*;

class Solution {
    private int answer = 0;
    
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> aDivisor = new ArrayList<>(),
                      bDivisor = new ArrayList<>();
        
        divisorAdd(aDivisor, arrayA);
        divisorAdd(bDivisor, arrayB);
        setAnswer(aDivisor, arrayB);
        setAnswer(bDivisor, arrayA);
        
        return answer;
    }
    
    // 반대 배열에서 나누어지지 않는 값 찾기
    public void setAnswer(List<Integer> divisorList, int[] arr) {
        for (int num : divisorList) {
            if (num <= answer) break;
            if (canDivide(arr, num)) continue;
            answer = num;
            return;
        }
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
    
    // 배열의 모든 값들의 공통된 약수 찾아서 넣기
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