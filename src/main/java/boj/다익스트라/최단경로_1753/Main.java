package boj.다익스트라.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int V;
    private static int E;
    private static int K;
    private static List<List<Pos>> map;
    private static long[] dijkstra;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        PriorityQueue<Pos> pq = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        dijkstra[K] = 0;
        pq.add(new Pos(K, 0));

        while (!pq.isEmpty()) {
            Pos poll = pq.poll();

            if (poll.weight == dijkstra[poll.v]) {
                for (Pos vertex : map.get(poll.v)) {
                    int curWeight = poll.weight + vertex.weight;
                    if (curWeight < dijkstra[vertex.v]) {
                        dijkstra[vertex.v] = curWeight;
                        pq.add(new Pos(vertex.v, curWeight));
                    }
                }
            }
        }

        for (int i = 1; i < V + 1; i++) {
            if (dijkstra[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }

            System.out.println(dijkstra[i]);
        }

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        dijkstra = new long[V + 1];

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(r).add(new Pos(c, weight));
        }

        Arrays.fill(dijkstra, Integer.MAX_VALUE);
    }

    private static class Pos {
        int v;
        int weight;

        public Pos(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
}
