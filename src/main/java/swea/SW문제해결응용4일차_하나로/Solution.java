package swea.SW문제해결응용4일차_하나로;

import java.util.*;
import java.io.*;


class Solution
{
    private static int T, N;
    private static long answer;
    private static int[][] islands;
    private static Edge[] edges;
    private static int[] parent;
    public static void main(String args[]) throws Exception
    {
        init();
    }

    private static void solve(double E, int count) {
        for(Edge edge : edges) {
            int i1 = edge.i1;
            int i2 = edge.i2;
            long weight = edge.weight;

            if(find(i1) != find(i2)) {
                union(i1, i2);
                answer += weight;
            }
        }

        System.out.println("#" + count + " " + Math.round(E * answer));
    }

    private static void union(int i1, int i2) {
        int a = find(i1);
        int b = find(i2);

        if(a != b) {
            parent[b] = a;
        }
    }

    private static int find(int island) {
        if(parent[island] < 0) {
            return island;
        }

        return parent[island] = find(parent[island]);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1, st2;

        T = Integer.parseInt(br.readLine());
        int count = 1;

        while(T > 0) {
            N = Integer.parseInt(br.readLine());
            islands = new int[N][2];
            parent = new int[N];
            Arrays.fill(parent, -1);
            answer = 0;

            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                int r = Integer.parseInt(st1.nextToken());
                int c = Integer.parseInt(st2.nextToken());
                islands[i] = new int[] {r, c};
            }

            double E = Double.parseDouble(br.readLine());

            List<Edge> list = new ArrayList<>();

            for(int i = 0; i < N - 1; i++) {
                int[] i1 = islands[i];
                for(int j = i + 1; j < N; j++) {
                    int[] i2 = islands[j];

                    long length = getLength(i1, i2);

                    list.add(new Edge(i, j, length));
                }
            }

            edges = new Edge[list.size()];
            for(int i = 0; i < list.size(); i++) {
                edges[i] = list.get(i);
            }

            Arrays.sort(edges, (o1, o2) -> Long.compare(o1.weight, o2.weight));

            solve(E, count);

            T--;
            count++;
        }

    }

    private static long getLength(int[] i1, int[] i2) {
        int r1 = i1[0];
        int c1 = i1[1];
        int r2 = i2[0];
        int c2 = i2[1];

        long d1 = Math.abs(r2 - r1);
        long d2 = Math.abs(c2 - c1);

        return d1 * d1 + d2 * d2;
    }

    private static class Edge{
        int i1;
        int i2;
        long weight;

        public Edge(int i1, int i2, long weight){
            this.i1 = i1;
            this.i2 = i2;
            this.weight = weight;
        }
    }
}