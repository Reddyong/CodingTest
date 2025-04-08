package boj.마법사상어와복제_23290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int S;
    private static int max;
    private static int[] shark;
    private static List<Fish> fishList;
    private static List<Fish> copyFishList;
    private static List<Fish> deletedFishList;
    private static int[][] visited;
    private static int[] fishDr = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] fishDc = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] sharkDr = new int[]{-1, 0, 1, 0};
    private static int[] sharkDc = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        while (S > 0) {
            // 물고기 이동
            moveFish();

            // 상어 3칸 이동
            max = 0;
            dfs(shark[0], shark[1], 0, new ArrayList<>());

            // 물고기 냄새 2번 지난 곳 있나 확인
            checkFishSmell();

            // 복제 물고기 추가
            addCopiedFish();

            S--;
        }

        System.out.println(fishList.size());
    }

    private static void addCopiedFish() {
        for (Fish fish : copyFishList) {
            fishList.add(fish);
        }
    }

    private static void checkFishSmell() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (visited[i][j] > 0) {
                    visited[i][j]++;
                }

                if (visited[i][j] > 2) {
                    visited[i][j] = 0;
                }
            }
        }

        for (Fish fish : deletedFishList) {
            visited[fish.r][fish.c] = 1;
            for (int i = 0; i < copyFishList.size(); i++) {
                Fish copy = copyFishList.get(i);
                if (copy.r == fish.r && copy.c == fish.c && copy.dir == fish.dir) {
                    copyFishList.remove(i);
                }
            }
        }
    }

    private static void dfs(int r, int c, int depth, List<Fish> fishes) {
        if (depth == 3) {
            if (fishes.size() > max) {
                max = fishes.size();
                shark[0] = r;
                shark[1] = c;
                deletedFishList = new ArrayList<>(fishes);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + sharkDr[i];
            int nc = c + sharkDc[i];

            if (isInBoard(nr, nc)) {
                dfs(nr, nc, depth + 1, fishes);
            }
        }
    }

    private static void moveFish() {
        copyFishList = new ArrayList<>();

        for (Fish fish : fishList) {
            int dir = fish.dir;
            int nr = fish.r + fishDr[dir];
            int nc = fish.c + fishDc[dir];

            int count = 0;
            while (!isCorrectDir(nr, nc)) {
                dir--;
                count++;

                if (dir == -1) {
                    dir = 7;
                }

                if (count == 8) {
                    return;
                }

                nr = fish.r + fishDr[dir];
                nc = fish.c + fishDc[dir];
            }

            copyFishList.add(new Fish(nr, nc, dir));
        }
    }

    private static boolean isCorrectDir(int r, int c) {
        if (!isInBoard(r, c)) {
            return false;
        }

        if (visited[r][c] > 0) {
            return false;
        }

        if (r == shark[0] && c == shark[1]) {
            return false;
        }

        return true;
    }

    private static boolean isInBoard(int r, int c) {
        if (r < 0 || c < 0 || r >= 4 || c >= 4) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        fishList = new ArrayList<>();

        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        visited = new int[4][4];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            Fish fish = new Fish(r, c, dir);
            fishList.add(fish);
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        shark = new int[]{r, c};
    }

    private static class Fish {
        int r;
        int c;
        int dir;

        public Fish(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dir=" + dir +
                    '}';
        }
    }
}
