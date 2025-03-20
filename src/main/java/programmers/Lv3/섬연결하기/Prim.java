package programmers.Lv3.섬연결하기;

import java.util.*;

class Prim {
    private boolean[] visited;
    private List<List<Pos>> list;
    private int answer;
    public int solution(int n, int[][] costs) {
        init(n, costs);
        solve(costs);

        return answer;
    }

    private void solve(int[][] costs){
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Pos(costs[0][0], 0));

        while(!pq.isEmpty()){
            Pos poll = pq.poll();

            if(visited[poll.v]){
                continue;
            }

            visited[poll.v] = true;
            answer += poll.weight;

            for(Pos vertex : list.get(poll.v)){
                if(!visited[vertex.v]){
                    pq.add(new Pos(vertex.v, vertex.weight));
                }
            }
        }
    }

    private void init(int n, int[][] costs){
        visited = new boolean[n];
        answer = 0;
        list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] cost : costs){
            int r = cost[0];
            int c = cost[1];
            int weight = cost[2];

            list.get(r).add(new Pos(c, weight));
            list.get(c).add(new Pos(r, weight));
        }
    }

    private class Pos{
        int v;
        int weight;

        public Pos(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Prim sol = new Prim();
        int solution = sol.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}});

        System.out.println("solution = " + solution);
    }
}
