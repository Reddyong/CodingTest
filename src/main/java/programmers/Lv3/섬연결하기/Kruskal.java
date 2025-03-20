package programmers.Lv3.섬연결하기;

import java.util.*;

class Kruskal {
    private int answer;
    private int[] parent;
    public int solution(int n, int[][] costs) {
        init(n, costs);
        solve(costs);

        return answer;
    }

    private void solve(int[][] costs){
        for(int[] cost : costs){
            int r = cost[0];
            int c = cost[1];
            int weight = cost[2];

            if(find(r) != find(c)){
                union(r, c);
                answer += weight;
            }
        }
    }

    private int find(int a){
        if(parent[a] < 0){
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }

    private void init(int n, int[][] costs){
        answer = 0;
        parent = new int[n];

        Arrays.fill(parent, -1);
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
    }

    public static void main(String[] args) {
        Kruskal sol = new Kruskal();
        int solution = sol.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});

        System.out.println("solution = " + solution);
    }
}
