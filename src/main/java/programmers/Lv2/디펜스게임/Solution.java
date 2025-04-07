package programmers.Lv2.디펜스게임;

import java.util.*;

class Solution {
    private PriorityQueue<Integer> pq;
    private int answer;
    public int solution(int n, int k, int[] enemy) {
        solve(n, k, enemy);

        return answer;
    }

    private void solve(int n, int k, int[] enemy){
        pq = new PriorityQueue<>();
        answer = 0;

        for(int i = 0; i < enemy.length; i++){
            if(k > 0){
                pq.add(enemy[i]);
                k--;
            } else{
                if(pq.peek() < enemy[i]){
                    int poll = pq.poll();
                    n -= poll;
                    pq.add(enemy[i]);
                } else{
                    n -= enemy[i];
                }
            }

            if(n < 0){
                return;
            }

            answer++;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        int solution2 = sol.solution(2, 4, new int[]{3, 3, 3, 3});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
