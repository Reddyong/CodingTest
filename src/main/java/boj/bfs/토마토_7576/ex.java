package boj.bfs.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex {
    static int n;
    static int m;
    static int minDay;
    static int[][] map;
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();

        System.out.println(minDay);
    }

    private static void solve() {

        if (!checkNoneTomato()) {
            bfs();
            getMinDay();
            return;
        }

        minDay = 0;
    }

    private static boolean checkNoneTomato() {
        for (int[] days : map) {
            for (int day : days) {
                if (day == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void getMinDay() {
        for (int[] days : map) {
            for (int day : days) {
                if (day == 0) {
                    minDay = -1;
                    return;
                }

                if (day > minDay) {
                    minDay = day;
                }
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if (!isInBoard(nr, nc) || map[nr][nc] != 0) {
                    continue;
                }

                queue.add(new int[]{nr, nc, poll[2] + 1});
                map[nr][nc] = poll[2] + 1;
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
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;

                if (cur == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
    }
}
