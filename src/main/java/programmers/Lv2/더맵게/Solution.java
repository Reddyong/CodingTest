package programmers.Lv2.더맵게;

import java.util.*;

class Solution {
    private PriorityQueue<Integer> pq;
    private int answer;
    public int solution(int[] scoville, int K) {
        init(scoville);
        solve(K);

        return answer;
    }

    private void solve(int K){
        while(pq.size() > 1 && pq.peek() < K){
            int first = pq.poll();
            int second = pq.poll();

            int food = first + second * 2;

            pq.add(food);
            answer++;
        }

        if(pq.peek() < K){
            answer = -1;
        }
    }

    private void init(int[] scoville){
        pq = new PriorityQueue<>();
        answer = 0;

        for(int s : scoville){
            pq.add(s);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);

        System.out.println("solution = " + solution);
    }
}