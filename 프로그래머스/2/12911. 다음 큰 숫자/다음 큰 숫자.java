class Solution {
    
    public static int oneCount(String s) {
        int result = 0;
        
        for (char c : s.toCharArray())
            if (c == '1') result++;
        
        return result;
    }
    
    public int solution(int n) {
        int result = 0;
        
        String nToBinary = Integer.toString(n, 2);
        int orignOneCount = oneCount(nToBinary);
        
        int sum = 1;
        while (true) {
            String sumToBinary = Integer.toString(n + sum, 2);
            int sumOneCount = oneCount(sumToBinary);

            if (sumOneCount > orignOneCount) {
                sum++;
                continue;
            }
            
            int convertCount = orignOneCount - sumOneCount;          
            StringBuilder createBinary = new StringBuilder();
            for (int i = sumToBinary.length() - 1; i >= 0; i--) {
                char c = sumToBinary.charAt(i);
                if (convertCount > 0 && c == '0') {
                    c = '1';
                    convertCount--;
                }
                createBinary.append(c);
            }
            result = Integer.parseInt(createBinary.reverse().toString(),2);
            break;
        }
        
        return result;
    }
}

/*

1을 더한 2진수값을 받고

1 개수만큼 뒤에서 부족하면 0을 1로 바꾸고
더 많으면 1을 더 더해
위에꺼 반복

1111
10000
10111

1001110
1001111
1010000
1010011

*/