package boj.bfs.불_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex {
    static int R;
    static int C;
    static String[][] map;
    static int[][] distF;
    static int[][] distJ;
    static Queue<int[]> queueF = new LinkedList<>();
    static Queue<int[]> queueJ = new LinkedList<>();
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        bfsFire();
        bfsJihun();
    }

    private static void bfsJihun() {
        while (!queueJ.isEmpty()) {
            int[] poll = queueJ.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if (!isInBoard(nr, nc)) {
                    System.out.println(distJ[poll[0]][poll[1]] + 1);
                    return;
                }

                if (map[nr][nc].equals("#") || distJ[nr][nc] >= 0) {
                    continue;
                }

                if (distF[nr][nc] != -1 && distF[nr][nc] <= distJ[poll[0]][poll[1]] + 1) {
                    continue;
                }

                queueJ.add(new int[]{nr, nc});
                distJ[nr][nc] = distJ[poll[0]][poll[1]] + 1;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static void bfsFire() {
        while (!queueF.isEmpty()) {
            int[] poll = queueF.poll();

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if (!isInBoard(nr, nc) || map[nr][nc].equals("#") || distF[nr][nc] >= 0) {
                    continue;
                }

                queueF.add(new int[]{nr, nc});
                distF[nr][nc] = distF[poll[0]][poll[1]] + 1;
            }
        }
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        distF = new int[R][C];
        distJ = new int[R][C];

        for (int i = 0; i < R; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                distF[i][j] = -1;
                distJ[i][j] = -1;

                if (row[j].equals("J")) {
                    queueJ.add(new int[]{i, j});
                    distJ[i][j] = 0;
                }

                if (row[j].equals("F")) {
                    queueF.add(new int[]{i, j});
                    distF[i][j] = 0;
                }

                map[i][j] = row[j];
            }
        }

    }
}
