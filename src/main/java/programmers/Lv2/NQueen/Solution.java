package programmers.Lv2.NQueen;

import java.util.*;

class Solution {
    private int answer;
    private int[] board;
    private boolean[] visited;
    public int solution(int n) {
        // 초기화
        init(n);
        // 풀이 과정
        solve(n);

        return answer;
    }

    private void solve(int n){
        // 백트래킹
        dfs(0, n);
    }

    private void dfs(int depth, int n){
        if(depth == n){
            answer++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(isPossible(depth, i, n)){
                    board[depth] = i;
                    visited[i] = true;
                    dfs(depth + 1, n);
                    visited[i] = false;
                }
            }
        }
    }

    private boolean isPossible(int col, int row, int n){
        for(int i = 0; i < col; i++){
            if(Math.abs(col - i) == Math.abs(row - board[i])){
                return false;
            }
        }

        return true;
    }

    private void init(int n){
        answer = 0;
        board = new int[n];
        visited = new boolean[n];
        Arrays.fill(board, -1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(4);
        System.out.println("solution = " + solution);
    }
}
