package boj.시뮬레이션.스티커붙이기_18808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] notebook;
    static List<int[][]> stickers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];

            for (int a = 0; a < r; a++) {
                st = new StringTokenizer(br.readLine());
                for (int b = 0; b < c; b++) {
                    sticker[a][b] = Integer.parseInt(st.nextToken());
                }
            }

            stickers.add(sticker);
        }
    }
}
