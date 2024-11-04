package boj.시뮬레이션.스티커붙이기_18808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1 {
    static int N;
    static int M;
    static int K;
    static int ans;
    static int[][] notebook;
    static List<Sticker> stickers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (Sticker sticker : stickers) {
            putOnSticker(sticker);
        }

        getResult();

        System.out.println(ans);
    }

    private static void getResult() {
        for (int[] nb : notebook) {
            for (int num : nb) {
                if (num == 1) {
                    ans++;
                }
            }
        }
    }

    private static void putOnSticker(Sticker sticker) {
        int r = sticker.r;
        int c = sticker.c;

        for (int rot = 0; rot < 4; rot++) {
            for (int i = 0; i <= N - r; i++) {
                for (int j = 0; j <= M - c; j++) {
                    if (isPossibleSticker(i, j, sticker)) {
                        return;
                    }
                }
            }

            changeDirection(sticker);

            int temp = sticker.r;
            r = temp;
            c = sticker.c;
        }
    }

    private static void changeDirection(Sticker sticker) {
        int r = sticker.r;
        int c = sticker.c;
        int len = sticker.cur.length;
        int[][] cur = new int[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                cur[i][j] = sticker.cur[len - 1 - j][i];
            }
        }

        sticker.r = c;
        sticker.c = r;
        sticker.cur = cur;
    }

    private static boolean isPossibleSticker(int i, int j, Sticker sticker) {
        for (int r = 0; r < sticker.r; r++) {
            for (int c = 0; c < sticker.c; c++) {
                if (notebook[i + r][j + c] == 1 && sticker.cur[r][c] == 1) {
                    return false;
                }
            }
        }

        for (int r = 0; r < sticker.r; r++) {
            for (int c = 0; c < sticker.c; c++) {
                if (sticker.cur[r][c] == 1) {
                    notebook[i + r][j + c] = 1;
                }
            }
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] cur = new int[r][c];

            for (int a = 0; a < r; a++) {
                st = new StringTokenizer(br.readLine());
                for (int b = 0; b < c; b++) {
                    cur[a][b] = Integer.parseInt(st.nextToken());
                }
            }

            stickers.add(new Sticker(r, c, cur));
        }
    }

    private static class Sticker{
        int r;
        int c;
        int[][] cur;

        public Sticker(int r, int c, int[][] cur) {
            this.r = r;
            this.c = c;
            this.cur = cur;
        }
    }
}
