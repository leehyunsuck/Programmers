import java.util.function.Supplier;


class Solution {
    public String solution(String new_id) {
        
        // 1단계 : 소문자로 변환
        String answer = new_id.toLowerCase();
        
        // 2단계 : 허용x 문자 제거
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            
            if ( c == 95 || c == 45 || c == 46 || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                // 3단계 : . 연속 사용 제거
                if ( c == 46 && strBuilder.length() != 0 && strBuilder.charAt(strBuilder.length() - 1) == 46) continue; 
                strBuilder.append(c);
            }
        }
        
        
        Supplier<Integer> strLen = () -> strBuilder.length();
    
        // 4단계 : 처음 , 마지막에 . 제거
        if (strLen.get() > 0 && strBuilder.charAt(0) == 46) strBuilder.deleteCharAt(0);
        if (strLen.get() > 0 && strBuilder.charAt(strLen.get() - 1) == 46) strBuilder.deleteCharAt(strLen.get() - 1);
        
        // 5단계 : 빈 문자열이면 a 대입
        if (strLen.get() == 0) strBuilder.append("a");
        
        // 6단계 : 16자 이상이면 16자 부터 제거, 제거 후 마지막이 . 이면 . 제거
        if (strLen.get() >= 16) strBuilder.delete(15, strLen.get());
        if (strBuilder.charAt(strLen.get() - 1) == 46) strBuilder.deleteCharAt(strLen.get() - 1);
        
        // 7단계 : 2자 이하면 마지막 글자를 뒤에 붙임 (3자 될 때 까지)
        char lastC = strBuilder.charAt(strLen.get() - 1);
        for (int i = strLen.get(); i < 3; i++) strBuilder.append(lastC);

        
        
        answer = strBuilder.toString();
        
        return answer;
    }
}

/*

- : 45      . : 46      _ : 95        a ~ z : 97 ~ 122        0 ~ 9 : 48 ~ 57

아이디 추천:
- 소문자로 변경
- 불가능한 문자 제거
- . 두번 이상은 한번으로
- 빈 문자열이면 a
- 15자 제외한 나머지 제거
- 2자 이하면 마지막 문자를 3자 될때까지 끝에 붙임

*/