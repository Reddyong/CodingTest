package boj.bfs.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == K) {
                System.out.println(dist[poll[0]]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    // -1
                    next = poll[0] - 1;
                } else if (i == 1) {
                    // +1
                    next = poll[0] + 1;
                } else {
                    // *2
                    next = poll[0] * 2;
                }

                if (!isInBoard(next)) {
                    continue;
                }

                if (dist[next] != -1 && dist[next] < dist[poll[0]] + 1) {
                    continue;
                }

                queue.add(new int[]{next, dist[poll[0]] + 1});
                dist[next] = dist[poll[0]] + 1;
            }
        }
    }

    private static boolean isInBoard(int next) {
        if (next < 0 || next > 100000) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[100001];
        Arrays.fill(dist, -1);
    }
}
