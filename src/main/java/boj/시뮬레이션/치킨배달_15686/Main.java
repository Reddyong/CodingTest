package boj.시뮬레이션.치킨배달_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int ans;
    static int[][] city;
    static boolean[] visited;
    static List<Pos> house = new ArrayList<>();
    static List<Pos> chicken = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        chickenLength(0, 0);

        System.out.println(ans);
    }

    private static void chickenLength(int depth, int idx) {
        if (depth == M) {
            int cur = getCurLength();
            ans = Math.min(ans, cur);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                chickenLength(depth + 1, i);
                visited[i] = false;
            }
        }
    }

    private static int getCurLength() {
        int sum = 0;

        for (Pos h : house) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    Pos c = chicken.get(i);

                    int len = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
                    min = Math.min(min, len);
                }
            }
            sum += min;
        }

        return sum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    house.add(new Pos(i + 1, j + 1));
                }

                if (city[i][j] == 2) {
                    count++;
                    chicken.add(new Pos(i + 1, j + 1));
                }
            }
        }

        visited = new boolean[count];
    }

    private static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
