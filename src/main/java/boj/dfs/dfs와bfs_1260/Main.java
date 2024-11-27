package boj.dfs.dfs와bfs_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] board;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        dfs();
        bfs();
    }

    private static void bfs() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        visited[V] = true;
        queue.add(V);

        while (!queue.isEmpty()) {
            Integer prev = queue.poll();
            sb.append(prev).append(" ");

            for (int i = 1; i <= N; i++) {
                if (i == prev) {
                    continue;
                }

                int next = i;

                if (!visited[next] && board[prev][next] == 1) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(sb.toString());
    }

    private static void dfs() {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        visited = new boolean[N + 1];
        stack.push(V);

        while (!stack.isEmpty()) {
            Integer prev = stack.pop();

            if (visited[prev]) {
                continue;
            }

            visited[prev] = true;
            sb.append(prev).append(" ");

            for (int i = N; i >= 1; i--) {
                if (i == prev) {
                    continue;
                }

                int next = i;

                if (!visited[next] && board[prev][next] == 1) {
                    stack.push(next);
                }
            }
        }

        System.out.println(sb.toString());

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start][end] = 1;
            board[end][start] = 1;
        }
    }
}
