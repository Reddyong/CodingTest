package programmers.Lv2.과제진행하기;

import java.util.*;

class Solution {
    private Stack<Pos> stack;
    private List<String> list;
    private Pos[] planArr;
    private String[] answer;
    public String[] solution(String[][] plans) {
        // 초기화
        init(plans);
        // 풀이과정
        solve(plans);

        return answer;
    }

    private void solve(String[][] plans){
        // 새 배열에 옮겨 담기 - 시간 정수로 바꿔서
        changeToPosArr(plans);

        // 정렬하기
        // 시작시간 오름차순, 종료시간 오름차순
        Arrays.sort(planArr, (o1, o2) -> {
            if(o1.startTime == o2.startTime){
                return (o1.startTime + o1.playTime) - (o2.startTime + o2.playTime);
            }

            return o1.startTime - o2.startTime;
        });

        // 순차적으로 시간 비교하며 정답 구하기
        getResult();
    }

    private void getResult(){
        int now = planArr[0].startTime;
        for(int i = 0; i < planArr.length; i++){
            String name = planArr[i].name;
            int start = planArr[i].startTime;
            int play = planArr[i].playTime;

            while(!stack.isEmpty() && now < start){
                Pos pop = stack.pop();

                if(now + pop.playTime <= start){
                    now += pop.playTime;
                    list.add(pop.name);
                } else{
                    int remain = pop.playTime - (start - now);
                    stack.push(new Pos(pop.name, pop.startTime, remain));
                    now = start;
                }
            }

            stack.push(new Pos(name, start, play));
            now = start;
        }

        // stack에 들어있는 수행중인 과제들 수행하기
        while(!stack.isEmpty()){
            Pos pop = stack.pop();

            list.add(pop.name);
        }

        // 정답 배열로 변환
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
    }

    private void changeToPosArr(String[][] plans){
        for(int i = 0; i < plans.length; i++){
            String name = plans[i][0];
            int startTime = changeToMinute(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);

            planArr[i] = new Pos(name, startTime, playTime);
        }
    }

    private int changeToMinute(String time){
        String[] split = time.split(":");

        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }

    private void init(String[][] plans){
        stack = new Stack<>();
        list = new ArrayList<>();
        answer = new String[plans.length];
        planArr = new Pos[plans.length];
    }

    private class Pos{
        String name;
        int startTime;
        int playTime;

        public Pos(String name, int startTime, int playTime){
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] solution1 = sol.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        String[] solution2 = sol.solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        String[] solution3 = sol.solution(new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
