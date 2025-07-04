package boj.mst.도시분할계획_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, answer, max;
    private static int[][] map;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        // map 정보 초기화
        init();
        // 풀이 과정
        solve();
    }

    private static void solve() {
        for (int[] info : map) {
            int a = info[0];
            int b = info[1];

            if (find(a) != find(b)) {
                union(a, b);
                answer += info[2];
                max = info[2];
            }
        }

        System.out.println(answer - max);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int cur) {
        if (parent[cur] < 0) {
            return cur;
        }

        return parent[cur] = find(parent[cur]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        map = new int[M][3];
        answer = 0;
        max = 0;

        Arrays.fill(parent, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, (o1, o2) -> o1[2] - o2[2]);
    }

}
