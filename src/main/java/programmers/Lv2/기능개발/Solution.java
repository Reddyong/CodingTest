package programmers.Lv2.기능개발;

import java.util.*;

public class Solution {
    private Queue<Integer> queue;
    private List<Integer> list;
    private int[] answer;
    public int[] solution(int[] progresses, int[] speeds) {

        solve(progresses, speeds);

        return answer;
    }

    private void solve(int[] progresses, int[] speeds){
        list = new ArrayList<>();
        queue = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            queue.add(getCurDay(progresses[i], speeds[i]));
        }

        System.out.println(queue);

        int max = queue.poll();
        int count = 1;
        while(!queue.isEmpty()){
            int poll = queue.poll();

            if(poll > max){
                max = poll;
                list.add(count);
                count = 0;
            }

            count++;
        }

        list.add(count);

        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }

    }

    private int getCurDay(int progress, int speed){
        if((100 - progress) % speed == 0){
            return (100 - progress) / speed;
        } else{
            return (100 - progress) / speed + 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        int[] solution2 = sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
