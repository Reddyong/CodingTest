package boj.bfs.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static List<int[]> houses;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static int danji;
    static int count;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    bfs(i, j);
                    houses.add(new int[]{danji, count});
                    danji++;
                }
            }
        }

        System.out.println(danji - 1);
        Collections.sort(houses, ((o1, o2) -> o1[1] - o2[1]));

        for (int[] house : houses) {
            System.out.println(house[1]);
        }
    }

    private static void bfs(int r, int c) {
        count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        count++;
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if (isInBoard(nr, nc) && !visited[nr][nc] && board[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                    count++;
                }
            }
        }
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        houses = new ArrayList<>();
        danji = 1;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
    }
}
