package boj.bfs.그림_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ex {
    private static int n;
    private static int m;
    private static int max;
    private static int num;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = new int[]{0, 1, 0, -1};
    private static int[] dc = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {

        init();
        solve();

        System.out.println(num);
        System.out.println(max);
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    num++;
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if (!isInBoard(nr, nc) || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        if (count > max) {
            max = count;
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
        String rowAndCol = br.readLine();
        n = Integer.parseInt(rowAndCol.substring(0, 1));
        m = Integer.parseInt(rowAndCol.substring(2));
        max = 0;
        num = 0;
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
    }
}
