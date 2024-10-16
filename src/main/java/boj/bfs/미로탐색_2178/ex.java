package boj.bfs.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex {
    static int min;
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        init();
        bfs();

        System.out.println(min);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == n - 1 && poll[1] == m - 1) {
                min = poll[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if (!isInBoard(nr, nc) || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                queue.add(new int[]{nr, nc, poll[2] + 1});
                visited[nr][nc] = true;
            }
        }
    }

    private static boolean isInBoard(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
    }
}
