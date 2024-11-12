class Solution {
    public String solution(String p) {
        return this.trans(p);
    }
    
    // 변환
    public String trans(String str) {
        // [1]
        if (str.length() == 0)
            return str;
        
        // [2]
        String[] arrUV = this.splitUV(str);
        String  u = arrUV[0],
                v = arrUV[1];
        
        // [3]
        if (this.check(u)) {
            // [3-1]
            String vResult = this.trans(v);
            return u + vResult;
        }
        
        // [4]
        return this.createNewStr(u, v);
    }
    
    // [4] 용 메소드
    public String createNewStr(String u, String v) {
        StringBuilder make = new StringBuilder();
        make.append('(');
        make.append(this.trans(v));
        make.append(')');
        
        for (int i = 1; i < u.length() - 1; i++)
            make.append(u.charAt(i) == '(' ? ')' : '(');
        
        return make.toString();
    }
    
    // [3-1] 용 메소드
    public boolean check(String str) {
        int check = 0;
        
        for (char c : str.toCharArray()) {
            if (c == '(') check++;
            else if (c == ')' && check > 0) check--;
            else return false;
        }
        return check == 0;
    }

    // [2] 용 메소드
    public String[] splitUV(String str) {
        String[] result = new String[2];
        
        int uIdx = 0,
            uCount = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') uCount++;
            else uCount--;
            uIdx++;
            
            if (uCount == 0)
                break;
        }
        
        return new String[] { str.substring(0, uIdx), str.substring(uIdx) };
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