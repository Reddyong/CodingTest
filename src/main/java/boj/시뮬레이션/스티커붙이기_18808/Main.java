package boj.시뮬레이션.스티커붙이기_18808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[][] note = new int[42][42];
    static int r, c; // 이렇게 전역변수로 저장해놓기 그냥.
    static int[][] paper = new int[12][12]; // 스티커 클래스 만들 필요가 없죠?

    //클래스로 만들어서 헤비하게 다니지말고 그때그때 필요한 부분만 사용. 굳이 스티커 정보를 다 저장하고 다닐 필요가없음.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //붙이면 다음으로 넘어가야됨 못붙이면 90도 돌리기.
            check :
            for (int rot = 0; rot < 4; rot++) {
                for (int x = 0; x <= n - r; x++) { // n = 7, r = 5인 상황 상상가능.
                    for (int y = 0; y <= m - c; y++) {
                        if (postable(x, y)) {
                            break check;
                        }
                    }
                }
                rotate(); // rot = 3 일때 rotate 실행시키면 안되지만 복잡도 그렇게 크게 증가 x
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += note[i][j];
            }
        }
        System.out.println(count);
    }

    static boolean postable(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (note[x + i][y + j] == 1 && paper[i][j] == 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1) {
                    note[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    static void rotate() {
        int[][] temp = new int[12][12];

        for (int i = 0; i < r; i++) {
            System.arraycopy(paper[i], 0, temp[i], 0, c);
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                paper[i][j] = temp[r - 1 - j][i];
            }
        }
        int tmp = r;
        r = c;
        c = tmp;
    }
//    static int N;
//    static int M;
//    static int K;
//    static int ans;
//    static int[][] notebook;
//    static List<int[][]> stickers = new ArrayList<>();
//    public static void Solution(String[] args) throws IOException {
//        init();
//        solve();
//    }
//
//    private static void solve() {
//        for (int[][] sticker : stickers) {
//            putOnSticker(sticker);
//        }
//        getResult();
//
//        System.out.println(ans);
//    }
//
//    private static void putOnSticker(int[][] sticker) {
//        int[][] copiedSticker = copySticker(sticker);
//
//        for (int rot = 0; rot < 4; rot++) {
//            int r = copiedSticker.length;
//            int c = copiedSticker[0].length;
//            for (int i = 0; i <= N - r; i++) {
//                for (int j = 0; j <= M - c; j++) {
//                    if (postable(i, j, copiedSticker)) {
//                        return;
//                    }
//                }
//            }
//
//            copiedSticker = changeDirection(copiedSticker);
//        }
//    }
//
//    private static boolean postable(int r, int c, int[][] sticker) {
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                if (notebook[r + i][c + j] == 1 && sticker[i][j] == 1) {
//                    return false;
//                }
//            }
//        }
//
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//                if (sticker[i][j] == 1) {
//                    notebook[r + i][c + j] = 1;
//                }
//            }
//        }
//
//        return true;
//    }
//
//    private static int[][] changeDirection(int[][] sticker) {
//        int r = sticker[0].length;
//        int c = sticker.length;
//        int[][] temp = new int[r][c];
//
//
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = 0; j < temp[i].length; j++) {
//                temp[i][j] = sticker[c - 1 - j][i];
//            }
//        }
//
//        return temp;
//    }
//
//    private static int[][] copySticker(int[][] sticker) {
//        int[][] tmp = new int[sticker.length][sticker[0].length];
//
//        for (int i = 0; i < tmp.length; i++) {
//            for (int j = 0; j < tmp[i].length; j++) {
//                tmp[i][j] = sticker[i][j];
//            }
//        }
//
//        return tmp;
//    }
//
//    private static void getResult() {
//        for (int[] nb : notebook) {
//            for (int num : nb) {
//                if (num == 1) {
//                    ans++;
//                }
//            }
//        }
//    }
//
//    private static void init() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        ans = 0;
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        notebook = new int[N][M];
//
//        for (int i = 0; i < K; i++) {
//            st = new StringTokenizer(br.readLine());
//            int r = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            int[][] sticker = new int[r][c];
//
//            for (int a = 0; a < r; a++) {
//                st = new StringTokenizer(br.readLine());
//                for (int b = 0; b < c; b++) {
//                    sticker[a][b] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            stickers.add(sticker);
//        }
//    }
}
