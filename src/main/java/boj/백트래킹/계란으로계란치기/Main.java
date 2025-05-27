package boj.백트래킹.계란으로계란치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, answer;
    private static int[][] eggs;
    public static void main(String[] args) throws IOException {
        // 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        answer = Math.max(answer, totalCount());

        if (depth >= N) {
            return;
        }

        if (eggs[depth][0] <= 0) {
            dfs(depth + 1);
            return;
        }


        for (int i = 0; i < N; i++) {
            if (i == depth) {
                continue;
            }

            if (eggs[i][0] <= 0) {
                continue;
            }

            eggs[i][0] -= eggs[depth][1];
            eggs[depth][0] -= eggs[i][1];
            dfs(depth + 1);
            eggs[i][0] += eggs[depth][1];
            eggs[depth][0] += eggs[i][1];
        }
    }

    private static int totalCount() {
        int count = 0;
        for (int[] egg : eggs) {
            if (egg[0] <= 0) {
                count++;
            }
        }

        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        eggs = new int[N][2];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
