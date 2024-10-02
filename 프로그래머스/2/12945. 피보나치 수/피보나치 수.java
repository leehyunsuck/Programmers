class Solution {
    public int solution(int n) {
        int tempFirst = 0, tempSecond = 1;
        
        for (int i = 0; i < n; i++) {
            if (tempFirst >= 1234567 || tempSecond >= 1234567) {
                tempFirst %= 1234567;
                tempSecond %= 1234567;
            }
            int save = tempFirst;
            tempFirst += tempSecond;
            tempSecond = save;
        }
        return tempFirst % 1234567;
    }
}

//     재귀함수 시간초과 
//     public int fibo(int n) {
//         if (n <= 1) return n;
//         return fibo(n-1) + fibo(n-2);
//     }
    
//     public int solution(int n) {
//         return fibo(n) % 1234567;
//     }