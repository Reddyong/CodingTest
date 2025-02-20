package programmers.Lv2.숫자변환하기;

import java.util.*;

class Solution {
    private int answer;
    private Queue<Num> queue;
    private boolean[] visited;
    public int solution(int x, int y, int n) {
        solve(x, y, n);

        return answer;
    }

    private void solve(int x, int y, int n){
        queue = new LinkedList<>();
        visited = new boolean[y + 1];
        queue.add(new Num(x, 0));
        visited[x] = true;

        while(!queue.isEmpty()){
            Num poll = queue.poll();

            if(poll.cur == y){
                answer = poll.depth;
                return;
            }

            for(int i = 0; i < 3; i++){
                int nCur = poll.cur;

                if(i == 0){
                    nCur += n;
                } else if(i == 1){
                    nCur *= 2;
                } else{
                    nCur *=3;
                }

                if(nCur <= y && !visited[nCur]){
                    visited[nCur] = true;
                    queue.add(new Num(nCur, poll.depth + 1));
                }
            }
        }

        answer = -1;
    }

    private class Num{
        int cur;
        int depth;

        public Num(int cur, int depth){
            this.cur = cur;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(10, 40, 5);
        int solution2 = sol.solution(10, 40, 30);
        int solution3 = sol.solution(2, 5, 4);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}