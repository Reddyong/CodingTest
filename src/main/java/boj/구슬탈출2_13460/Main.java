package boj.구슬탈출2_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N;
    private static int M;
    private static String[][] board;
    private static boolean[][][][] visited;
    private static int[] R;
    private static int[] B;
    private static int[] O;
    private static int[] dr = new int[]{1, 0, -1, 0};   // 남, 동, 북, 서
    private static int[] dc = new int[]{0, 1, 0, -1};
    private static int answer;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(R[0], R[1], B[0], B[1], 1));
        visited[R[0]][R[1]][B[0]][B[1]] = true;

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();

            int curRR = poll.rR;
            int curRC = poll.rC;
            int curBR = poll.bR;
            int curBC = poll.bC;

            if (poll.count > 10) {
                answer = -1;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newRR = curRR;
                int newRC = curRC;
                int newBR = curBR;
                int newBC = curBC;

                boolean isRedInHole = false;
                boolean isBlueInHole = false;

                while (!board[newRR + dr[i]][newRC + dc[i]].equals("#")) {
                    newRR += dr[i];
                    newRC += dc[i];

                    if (newRR == O[0] && newRC == O[1]) {
                        isRedInHole = true;
                        break;
                    }
                }

                while (!board[newBR + dr[i]][newBC + dc[i]].equals("#")) {
                    newBR += dr[i];
                    newBC += dc[i];

                    if (newBR == O[0] && newBC == O[1]) {
                        isBlueInHole = true;
                        break;
                    }
                }

                if (isBlueInHole) {
                    continue;
                }

                if (isRedInHole && !isBlueInHole) {
                    answer = poll.count;
                    return;
                }

                if (newRR == newBR && newRC == newBC) {
                    if (i == 0) {
                        if (curRR < curBR) {
                            newRR -= dr[i];
                        } else {
                            newBR -= dr[i];
                        }
                    } else if (i == 1) {
                        if (curRC < curBC) {
                            newRC -= dc[i];
                        } else {
                            newBC -= dc[i];
                        }
                    } else if (i == 2) {
                        if (curRR < curBR) {
                            newBR -= dr[i];
                        } else {
                            newRR -= dr[i];
                        }
                    } else {
                        if (curRC < curBC) {
                            newBC -= dc[i];
                        } else {
                            newRC -= dc[i];
                        }
                    }
                }

                if (!visited[newRR][newRC][newBR][newBC]) {
                    visited[newRR][newRC][newBR][newBC] = true;
                    queue.add(new Pos(newRR, newRC, newBR, newBC, poll.count + 1));
                }
            }
        }

        answer = -1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        visited = new boolean[N][M][N][M];
        board = new String[N][M];
        answer = 0;

        for(int i = 0; i < N; i++){
            String line = br.readLine();

            for(int j = 0; j < M; j++){
                board[i][j] = String.valueOf(line.charAt(j));

                if(line.charAt(j) == 'R'){
                    R = new int[]{i, j};
                }

                if (line.charAt(j) == 'B') {
                    B = new int[]{i, j};
                }

                if(line.charAt(j) == 'O'){
                    O = new int[]{i, j};
                }
            }
        }
    }

    private static class Pos {
        int rR;
        int rC;
        int bR;
        int bC;
        int count;

        public Pos(int rR, int rC, int bR, int bC, int count) {
            this.rR = rR;
            this.rC = rC;
            this.bR = bR;
            this.bC = bC;
            this.count = count;
        }
    }
}
