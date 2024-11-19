class Solution {
    public String replaceHash(String str) {
        StringBuilder strBuilder = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c != '#') strBuilder.append(c);
            else {
                int lastIdx = strBuilder.length() - 1;
                char lastChar = strBuilder.charAt(lastIdx);
                strBuilder.setCharAt(lastIdx, (char) (lastChar + 32));
            }
        }
        return strBuilder.toString();
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerTime = 0;

        m = this.replaceHash(m);
        
        for (String music : musicinfos) {
            // 시작시간, 끝시간, 이름, 악보
            String[] info = music.split(",");

            info[3] = this.replaceHash(info[3]);
            
            String[] startSplit = info[0].split(":");
            String[] endSplit = info[1].split(":");
            int time = (Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]))
                       - (Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]));
            
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < (time / info[3].length()) + 1; i++)
                builder.append(info[3]);
            
            String ableStr = builder.toString().substring(0, time);
            if (ableStr.contains(m) && time > answerTime) {
                answer = info[2];
                answerTime = time;
            } 
        }
        
        return answer;
    }
}