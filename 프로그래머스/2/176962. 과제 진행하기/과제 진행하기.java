import java.util.*;

class Solution {
    class Homework {
        private String name;
        private int startTime;
        private int needTime;
        
        public Homework(String name, int startTime, int needTime) {
            this.name = name;
            this.startTime = startTime;
            this.needTime = needTime;
        }
        
        public void setNeedTime(int needTime) {
            this.needTime = needTime;
        }
        
        public String getName() {
            return name;
        }
        
        public int getStartTime() {
            return startTime;
        }
        
        public int getNeedTime() {
            return needTime;
        }
        
        public int getEndTime() {
            return startTime + needTime;
        }
        
        public int getEndTime(int startTime) {
            return startTime + needTime;
        }
        
        public String toString() {
            return name + " :: " + startTime + " :: " + needTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        List<Homework> homeworkList = new ArrayList<>();
        for (String[] plan : plans) {
            String[] timeSplit = plan[1].split(":");
            String name = plan[0];
            int startTime = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            int needTime = Integer.parseInt(plan[2]);
            
            homeworkList.add(new Homework(name, startTime, needTime));
        }

        // 제한사항 [배열은 시간순으로 정렬되어 있지 않을 수 있습니다.]
        Collections.sort(homeworkList, (h1, h2) -> {
            return h1.getStartTime() - h2.getStartTime();
        });
        
        String[] answer = new String[homeworkList.size()];
        int answerIdx = 0;
        
        // 진행하다가 멈춘 과제
        Stack<Homework> stack = new Stack<>();

        // *주의* 끝남과 동시에 시작할 수 있음
        for (int idx = 0; idx < homeworkList.size(); idx++) {
            Homework nowHomework = homeworkList.get(idx);
            
            if (idx == homeworkList.size() - 1) {
                stack.add(nowHomework);
                break;
            }
            
            Homework nextHomework = homeworkList.get(idx + 1);
            
            int nowEndTime = nowHomework.getEndTime();
            int nextStartTime = nextHomework.getStartTime();
            
            // 다음 과제 전에 끝낼 수 있음
            if (nowEndTime <= nextStartTime) {
                answer[answerIdx++] = nowHomework.getName();
                
                // 남는 시간동안 하다 못한 과제 풀이
                while (nowEndTime < nextStartTime && !stack.isEmpty()) {
                    Homework popWork = stack.pop();
                    
                    // 끝까지 다 진행 가능
                    if (popWork.getEndTime(nowEndTime) <= nextStartTime) {
                        answer[answerIdx++] = popWork.getName();
                        nowEndTime = popWork.getEndTime(nowEndTime);
                    } else {
                        popWork.setNeedTime(popWork.getNeedTime() - (nextStartTime - nowEndTime));
                        stack.push(popWork);
                        break;
                    }
                }
            } else {
                stack.add(new Homework(nowHomework.getName(), 0, nowEndTime - nextStartTime));
            }
        }
        
        // 나머지 과제 진행
        while (!stack.isEmpty()) {
            answer[answerIdx++] = stack.pop().getName();
        }
        
        return answer;
    }
}