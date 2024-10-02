class Solution {
    public int solution(String s) {
        char[] sToCharArray = new char[s.length()];
        int index = 0;
        
        for (char c : s.toCharArray()) {
            if (index == 0 || sToCharArray[index-1] != c) sToCharArray[index++] = c;
            else index--;
        }
        
        return index == 0 ? 1 : 0;
    }
}

/*
스택 사용
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) stack.push(c);
            else stack.pop();
        }
        
        return stack.isEmpty() ? 1 : 0;
        
테스트 1 〉	통과 (0.31ms, 76.1MB)
테스트 2 〉	통과 (11.53ms, 80.3MB)
테스트 3 〉	통과 (11.74ms, 77.2MB)
테스트 4 〉	통과 (21.74ms, 87.2MB)
테스트 5 〉	통과 (20.76ms, 78.7MB)

평균 : 14.42ms, 79.9MB

====================================

배열
        char[] sToCharArray = new char[s.length()];
        int index = 0;
        
        for (char c : s.toCharArray()) {
            if (index == 0 || sToCharArray[index-1] != c) sToCharArray[index++] = c;
            else index--;
        }
        
        return index == 0 ? 1 : 0;
        
테스트 1 〉	통과 (0.03ms, 74.7MB)
테스트 2 〉	통과 (3.61ms, 79.4MB)
테스트 3 〉	통과 (4.29ms, 78.9MB)
테스트 4 〉	통과 (6.90ms, 79.6MB)
테스트 5 〉	통과 (7.11ms, 79.1MB)

평균 : 4.39ms, 78.34MB

====================================

배열에서 toCharArray 대신 charAt 사용
        char[] sToCharArray = new char[s.length()];
        int index = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (index == 0 || sToCharArray[index-1] != temp) sToCharArray[index++] = temp;
            else index--;
        }
        
        return index == 0 ? 1 : 0;

테스트 1 〉	통과 (0.03ms, 73.4MB)
테스트 2 〉	통과 (5.99ms, 87MB)
테스트 3 〉	통과 (7.18ms, 79.7MB)
테스트 4 〉	통과 (5.38ms, 81.6MB)
테스트 5 〉	통과 (7.84ms, 74.2MB)
    
평균 : 5.28ms, 79.58MB

====================================

ArrayList 사용
        List<Character> sToCharArray = new ArrayList<>();
        int index = 0;
        
        for (char c : s.toCharArray()) {
            if (index == 0 || sToCharArray.get(index-1) != c) {
                sToCharArray.add(c);
                index++;
            } else sToCharArray.remove(--index);
        }
        
        return index == 0 ? 1 : 0;

테스트 1 〉	통과 (0.14ms, 75.8MB)
테스트 2 〉	통과 (8.78ms, 80.3MB)
테스트 3 〉	통과 (10.95ms, 87.1MB)
테스트 4 〉	통과 (16.23ms, 76.8MB)
테스트 5 〉	통과 (11.15ms, 77.9MB)

평균 : 9.05ms, 79.58MB
*/