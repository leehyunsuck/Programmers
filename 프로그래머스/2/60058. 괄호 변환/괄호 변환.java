class Solution {
    public String solution(String p) {
        return this.trans(p);
    }
    
    public String trans(String str) {           // 변환
        if (str.length() == 0)                  // [1]
            return str;

        String[] arrUV = this.splitUV(str);     // [2]
        String  u = arrUV[0],
                v = arrUV[1];
        
        if (this.check(u)) {                    // [3]
            String vResult = this.trans(v);     // [3-1]
            return u + vResult;                 
        }
        
        return this.createNewStr(u, v);         // [4]
    }
    
    
    public String[] splitUV(String str) {       // [2] 용 메소드
        String[] result = new String[2];
        
        int uIdx = 0, uCount = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') uCount++;
            else uCount--;
            uIdx++;
            
            if (uCount == 0) break;
        }
        
        return new String[] { str.substring(0, uIdx), str.substring(uIdx) };
    }
    
    public boolean check(String str) {          // [3-1] 용 메소드
        int check = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') check++;
            else if (c == ')' && check > 0) check--;
            else return false;
        }
        return check == 0;
    }
    
    public String createNewStr(String u, String v) {    // [4] 용 메소드
        StringBuilder make = new StringBuilder();
        make.append('(');                               // [4-1]
        make.append(this.trans(v));                     // [4-2]
        make.append(')');                               // [4-3]
        
        for (int i = 1; i < u.length() - 1; i++)        // [4-4]
            make.append(u.charAt(i) == '(' ? ')' : '(');
        
        return make.toString();                         // [4-5]
    }
}

/*
변환과정
    1. if 빈문자열? -> return 빈문자열
    2. 문자열을 2개로 분리
        -> U (균형잡힌 괄호) (더 이상 분리 불가능하게)
        -> V (그 외) (빈 문자열 가능)
    3. if 문자열 U == 올바른? V에 대해 1단계부터 실행
        -> 결과를 U에 이어붙인 후 반환
    4. else 
        -> 빈 문자열에 첫 번째 문자로 ( 붙임
        -> V에 대해 1단계부터 수행한 결과 이어 붙임
        -> ) 붙임
        -> U의 첫 번째 문자 제거, 괄호 방향 뒤집어서 붙여
        -> return

균형잡힌
    - 괄호 개수 맞음

올바른
    - 괄호 개수 맞음 + 짝 맞음
    
요구사항
    - 매개변수(균형잡힌)를 올바른으로 변환
*/