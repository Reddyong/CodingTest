package boj.백트래킹.N과M_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            recur(String.valueOf(i), 1);
            visited[i] = false;
        }

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void recur(String cur, int depth) {
        if (depth == M) {
            list.add(cur);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recur(cur + " " + String.valueOf(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        visited[0] = true;
    }
}
