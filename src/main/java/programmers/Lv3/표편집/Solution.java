package programmers.Lv3.표편집;

import java.util.*;

class Solution {
    private int cur;
    private String answer;
    private int[] prevArr, nextArr;
    private Stack<Pos> stack;
    public String solution(int n, int k, String[] cmd) {
        // 초기화
        init(n, k);
        // 풀이 과정
        solve(n, cmd);

        return answer;
    }

    private void solve(int n, String[] cmd){
        // 명령 실행
        playCMD(n, cmd);
    }

    private void playCMD(int n, String[] cmd){
        StringBuilder sb = new StringBuilder("O".repeat(n));

        for(String c : cmd){
            String[] split = c.split(" ");

            if(split[0].equals("D")){
                // 아래 행으로 이동
                int len = Integer.parseInt(split[1]);

                while(len-- > 0){
                    cur = nextArr[cur];
                }
            } else if(split[0].equals("U")){
                // 윗 행으로 이동
                int len = Integer.parseInt(split[1]);

                while(len-- > 0){
                    cur = prevArr[cur];
                }
            } else if(split[0].equals("C")){
                // 행 삭제
                stack.push(new Pos(prevArr[cur], cur, nextArr[cur]));

                if(prevArr[cur] != -1){
                    nextArr[prevArr[cur]] = nextArr[cur];
                }

                if(nextArr[cur] != -1){
                    prevArr[nextArr[cur]] = prevArr[cur];
                }

                sb.setCharAt(cur, 'X');

                if(nextArr[cur] == -1){
                    cur = prevArr[cur];
                } else{
                    cur = nextArr[cur];
                }

            } else{
                // 행 복구
                Pos pop = stack.pop();

                if(pop.prev != -1){
                    nextArr[pop.prev] = pop.cur;
                }

                if(pop.next != -1){
                    prevArr[pop.next] = pop.cur;
                }

                sb.setCharAt(pop.cur, 'O');
            }
        }

        answer = sb.toString();
    }

    private void init(int n, int k){
        prevArr = new int[n];
        nextArr = new int[n];

        for(int i = 0; i < n; i++){
            prevArr[i] = i - 1;
            nextArr[i] = i + 1;
        }

        nextArr[n - 1] = -1;

        cur = k;
        stack = new Stack<>();
    }

    private class Pos{
        int prev;
        int cur;
        int next;

        public Pos(int prev, int cur, int next){
            this.prev = prev;
            this.cur = cur;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"});
        String solution2 = sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
