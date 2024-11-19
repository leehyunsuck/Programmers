class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerTime = 0;
        
        String[] replaceTarget = { "C#", "D#", "F#", "G#", "A#", "B#" };
        String[] replaceOption = { "c", "d", "f", "g", "a", "b" };
        
        for (int i = 0; i < replaceTarget.length; i++)
            m = m.replace(replaceTarget[i], replaceOption[i]);
        
        for (String music : musicinfos) {
            String[] info = music.split(",");
            String  start = info[0],
                    end   = info[1],
                    name  = info[2],
                    txt   = info[3];
            
            for (int i = 0; i < replaceTarget.length; i++)
                txt = txt.replace(replaceTarget[i], replaceOption[i]);
            
            String[] startSplit = start.split(":");
            String[] endSplit = end.split(":");
            
            int sTime = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]),
                eTime = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);
            
            int time = eTime - sTime;
            
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < (time / txt.length()) + 1; i++)
                builder.append(txt);
            
            String strBuilder = builder.toString().substring(0, time);
            
            if (strBuilder.contains(m)) {
                if (time > answerTime) {
                    answer = name;
                    answerTime = time;
                }
            }
        }
        
        return answer;
    }
}