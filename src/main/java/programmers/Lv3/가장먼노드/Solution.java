package programmers.Lv3.가장먼노드;

import java.util.*;

class Solution {
    private List<List<Integer>> list;
    private boolean[] visited;
    private int answer, max;
    public int solution(int n, int[][] edge) {
        init(n, edge);
        solve();

        return answer;
    }

    private void solve(){
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> o2.depth - o1.depth);
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(1, 0));
        visited[1] = true;

        while(!queue.isEmpty()){
            Pos poll = queue.poll();
            max = Math.max(poll.depth, max);

            boolean flag = false;
            for(int v : list.get(poll.v)){
                if(!visited[v]){
                    flag = true;
                    visited[v] = true;
                    queue.add(new Pos(v, poll.depth + 1));
                }
            }

            if(!flag){
                pq.add(poll);
            }
        }

        Pos peek = pq.peek();
        while(true){
            if(pq.isEmpty()){
                break;
            }

            Pos poll = pq.poll();
            if(peek.depth != poll.depth){
                break;
            }

            answer++;
        }
    }

    private void init(int n, int[][] edge){
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        answer = 0;
        max = 0;

        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] v : edge){
            int s = v[0];
            int e = v[1];

            list.get(s).add(e);
            list.get(e).add(s);
        }
    }

    private class Pos{
        int v;
        int depth;

        public Pos(int v, int depth){
            this.v = v;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});

        System.out.println("solution = " + solution);
    }
}
