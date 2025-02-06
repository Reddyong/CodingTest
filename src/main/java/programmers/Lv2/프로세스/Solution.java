package programmers.Lv2.프로세스;

import java.util.*;

class Solution {
    int answer;
    boolean[] visited;
    PriorityQueue<Integer> queue;
    public int solution(int[] priorities, int location) {
        init(priorities);
        solve(priorities, location);

        return answer;
    }

    private void solve(int[] priorities, int location){
        int index = 0;

        while(!queue.isEmpty()){
            int cur = priorities[index];
            int max = queue.peek();

            if(cur >= max && !visited[index]){
                answer++;
                queue.poll();
                visited[index] = true;

                if(index == location){
                    break;
                }
            }

            index++;
            if(index == priorities.length){
                index = 0;
            }
        }
    }

    private void init(int[] priorities){
        queue = new PriorityQueue<>(Comparator.reverseOrder());
        answer = 0;
        visited = new boolean[priorities.length];

        for(int priority : priorities){
            queue.add(priority);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{2, 1, 3, 2}, 2);
        int solution2 = sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
