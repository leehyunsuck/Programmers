// 깨알 공부
// Math.log10(숫자) + 1  == 숫자 타입 길이

class Solution {
    public long solution(long n) {
        int[] nToIntArr = this.longToIntArray(n);
        this.sort(nToIntArr, true);
        return this.intArrToLong(nToIntArr);
    }
    
    // int 배열을 [0]을 가장 큰 위치에 있는 long 값 반환
    public long intArrToLong(int[] arr) {
        long result = 0;
        
        for (int num : arr) {
            result = result * 10 + num;
        }
        
        return result;
    }
    
    // long 숫자를 int 배열로 변환하는 메소드
    public int[] longToIntArray(long n) {
        int[] result = new int[(int) (Math.log10(n) + 1)];
        
        int idx = result.length - 1;
        while (n > 0) {
            result[idx--] = (int) (n % 10);
            n /= 10;
        }
        
        return result;
    }
    
    // 정렬 false:오름차순 , true: 내림차순
    public void sort(int[] arr, boolean order) {
        for (int i = 0; i < arr.length; i++) {
            int orderIdx = i;
            
            for (int j = i + 1; j < arr.length; j++) {
                // 내림차순이면 더 작은값 인덱스번호 저장
                if (order && arr[orderIdx] < arr[j]) orderIdx = j;
                // 오름차순이면 더 큰값 인덱스번호 저장
                else if (!order && arr[orderIdx] > arr[j]) orderIdx = j;
            }
            
            // orderIdx 와 i 가 다르면 바꾸면됨
            if (orderIdx != i) {
                int temp = arr[i];
                arr[i] = arr[orderIdx];
                arr[orderIdx] = temp;
            }
        }
    }
}