// 문제 풀이 후 다른사람이 Split으로 풀이한 것 보고 해당 방식으로 다시 풀이

import java.util.*;

class Solution {
    private Map<Long, Boolean> decimalMap = new HashMap<>();
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] trans = Integer.toString(n, k).split("0");
        
        for (String s : trans) {
            if (s.length() == 0) continue;
            if (this.isDecimal(Long.parseLong(s))) answer++;
        }

        return answer;
    }
    
    // 소수 판별
    public boolean isDecimal(Long n) {
        if (n < 2 && !decimalMap.containsKey(n)) decimalMap.put(n, false);
        if (decimalMap.containsKey(n)) return decimalMap.get(n);

        int count = 0;
        for (long i = 1; i * i <= n && count <= 2; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i) count++;
            }
        }
        decimalMap.put(n, count == 2);
        
        return decimalMap.get(n);
    }
}


/*
기존 코드

import java.util.*;

class Solution {
    private Map<Long, Boolean> decimalMap = new HashMap<>();
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String trans = Integer.toString(n, k);
        
        StringBuilder saveNum = new StringBuilder();
        boolean zero = false;
        for (char c : trans.toCharArray()) {
            if (c != '0') {
                saveNum.append(c);
                continue;
            }
            
            if (!zero) zero = true;
            if (saveNum.length() == 0) continue;
            
            if (this.isDecimal(Long.parseLong(saveNum.toString()))) answer++;
            saveNum = new StringBuilder();
        }
        if (saveNum.length() != 0)
            if (this.isDecimal(Long.parseLong(saveNum.toString()))) answer++;

        return answer;
    }
    
    // 소수 판별
    public boolean isDecimal(Long n) {
        if (n < 2 && !decimalMap.containsKey(n)) decimalMap.put(n, false);
        if (decimalMap.containsKey(n)) return decimalMap.get(n);

        int count = 0;
        for (long i = 1; i * i <= n && count <= 2; i++) {
            if (n % i == 0) {
                count++;
                if (n / i != i) count++;
            }
        }
        decimalMap.put(n, count == 2);
        
        return count == 2;
    }
}


*/