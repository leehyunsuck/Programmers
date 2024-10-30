class Solution {
    public int solution(long num) {
        return recursionCollatz(num, 0);
    }
    
    public int recursionCollatz(long num, int repeat) {
        if (repeat >= 500)  return -1;      // 반복횟수가 500이면, -1 반환
        if (num == 1)       return repeat;  // num == 1이면, 반복횟수(repeat) 반환
        
        // num이 1도 아니고, repeat이 500 이상도 아니면 아래 구간
        
        // 조건 처리
        if (num % 2 == 0)   num /= 2l;
        else                num = num * 3l + 1l;
        
        // num 조건 처리 한 값과, 반복횟수에 1 추가한 값으로 해당 메소드 재호출
        return this.recursionCollatz(num, repeat + 1); 
    }
}