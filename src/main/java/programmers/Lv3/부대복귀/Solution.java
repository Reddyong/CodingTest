package programmers.Lv3.부대복귀;

import java.util.*;

class Solution {
    private int[] answer;
    private int[] dijkstra;
    private List<List<Integer>> graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 다익스트라 배열 초기화
        init(n, sources, destination);

        // 풀이 과정
        solve(n, roads, sources, destination);

        return answer;
    }

    private void solve(int n, int[][] roads, int[] sources, int destination){
        // road에 대한 인접 그래프 생성
        createGraph(n, roads);

        // destination부터 각 노드까지 최단거리 구하기
        // 다익스트라 알고리즘
        getShortestPath(destination);

        for(int i = 0; i < sources.length; i++){
            if(dijkstra[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1;
                continue;
            }

            answer[i] = dijkstra[sources[i]];
        }
    }

    private void getShortestPath(int destination){
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(new Pos(destination, 0));

        while(!pq.isEmpty()){
            Pos poll = pq.poll();

            if(poll.weight != dijkstra[poll.v]){
                continue;
            }

            for(int cur : graph.get(poll.v)){
                int curWeight = poll.weight + 1;

                if(dijkstra[cur] > curWeight){
                    dijkstra[cur] = curWeight;
                    pq.add(new Pos(cur, curWeight));
                }
            }
        }
    }

    private void createGraph(int n, int[][] roads){
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int r = road[0];
            int c = road[1];

            graph.get(r).add(c);
            graph.get(c).add(r);
        }
    }

    private void init(int n, int[] sources, int destination){
        answer = new int[sources.length];
        dijkstra = new int[n + 1];

        Arrays.fill(dijkstra, Integer.MAX_VALUE);
        dijkstra[destination] = 0;
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
        int[] solution1 = sol.solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1);
        int[] solution2 = sol.solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5}, 5);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}