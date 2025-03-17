package programmers.Lv2.배달;

import java.util.*;

class Solution {
    private int answer;
    private int[] dijkstra;
    private List<List<Pos>> map;
    public int solution(int N, int[][] road, int K) {
        init(N, road);
        solve(K);

        return answer;
    }

    private void solve(int K){
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Pos(1, 0));
        dijkstra[1] = 0;

        while(!pq.isEmpty()){
            Pos poll = pq.poll();

            if(poll.weight != dijkstra[poll.v]){
                continue;
            }

            for(Pos vertex : map.get(poll.v)){
                int curWeight = poll.weight + vertex.weight;

                if(curWeight < dijkstra[vertex.v]){
                    dijkstra[vertex.v] = curWeight;
                    pq.add(new Pos(vertex.v, curWeight));
                }
            }
        }

        for(int i = 1; i < dijkstra.length; i++){
            if(dijkstra[i] <= K)    {
                answer++;
            }
        }
    }

    private void init(int N, int[][] road){
        answer = 0;
        dijkstra = new int[N + 1];
        map = new ArrayList<>();

        Arrays.fill(dijkstra, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            map.add(new ArrayList<>());
        }

        for(int[] ro : road){
            int r = ro[0];
            int c = ro[1];
            int weight = ro[2];

            map.get(r).add(new Pos(c, weight));
            map.get(c).add(new Pos(r, weight));
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
        Solution sol = new Solution();
        int solution1 = sol.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        int solution2 = sol.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);

    }
}