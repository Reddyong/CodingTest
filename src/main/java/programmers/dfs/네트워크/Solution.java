package programmers.dfs.네트워크;

import java.util.Stack;

public class Solution {
    boolean[][] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        init(computers);
        answer = solve(n, computers);

        return answer;
    }

    private int solve(int n, int[][] computers) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && computers[i][j] == 1) {
                    dfs(n, computers, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int n, int[][] computers, int i, int j) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(i, j));
        visited[i][j] = true;
        visited[j][i] = true;

        while (!stack.isEmpty()) {
            Pos pop = stack.pop();

            for (int idx = 0; idx < n; idx++) {
                if (!visited[pop.j][idx] && computers[pop.j][idx] == 1) {
                    stack.push(new Pos(pop.j, idx));
                    visited[pop.j][idx] = true;
                    visited[idx][pop.j] = true;
                }
            }
        }
    }

    private void init(int[][] computers) {
        visited = new boolean[computers.length][computers[0].length];
    }

    private class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        int solution2 = sol.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
