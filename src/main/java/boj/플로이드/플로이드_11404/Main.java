package boj.플로이드.플로이드_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static int[][] floyd;
    public static void main(String[] args) throws IOException {
        // floyd 배열 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        // 플로이드 알고리즘으로 각 정점 간 최단거리 구하기
        for (int mid = 1; mid <= N; mid++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    floyd[i][j] = Math.min(floyd[i][mid] + floyd[mid][j], floyd[i][j]);
                }
            }
        }

        // 도달 할 수 없는 정점은 0, 나머지는 최단 거리 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (floyd[i][j] == 10000001) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(floyd[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        floyd = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    // N = 100, M = 100000 이 최대이기 때문에 N * M 보다 큰 값을 초기값으로 세팅
                    floyd[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            floyd[a][b] = Math.min(c, floyd[a][b]);
        }
    }
}
