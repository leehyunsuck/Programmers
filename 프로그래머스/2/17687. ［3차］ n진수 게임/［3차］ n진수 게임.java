class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        for (int number = 0, order = 1; answer.length() < t; number++) {
            String numberToString = this.numConvert(number, n);
            
            for (char c : numberToString.toCharArray()) {
                if (order == p) 
                    answer.append(c);
                
                if (answer.length() == t) 
                    break;
                
                order = order + 1 > m ? 1 : order + 1;
            }
        }

        return answer.toString();
    }
    
    // 기능 : Integer.toString(number++, n).toUpperCase();
    public String numConvert(int number, int n) {        
        if (number == 0)
            return "0";
        
        StringBuilder result = new StringBuilder();
        
        char[] data = {
            '0', '1', '2', '3', '4', '5', '6', '7', 
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        
        while (number > 0) {
            result.append(data[number % n]);
            number /= n;
        }
        result.reverse();
        
        return result.toString();
    }
}