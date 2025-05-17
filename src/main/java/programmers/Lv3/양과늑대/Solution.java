package programmers.Lv3.양과늑대;

import java.util.*;

class Solution {
    private int answer, maxSheep, N;
    private List<List<Integer>> map;
    public int solution(int[] info, int[][] edges) {
        init(info, edges);
        solve(info, edges);

        return answer;
    }

    private void solve(int[] info, int[][] edges){
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(0, 0, 0, nextNodes, info);

        answer = maxSheep;
    }

    private void dfs(int cur, int sheep, int wolf, List<Integer> nextNodes, int[] info){
        if(info[cur] == 0){
            // 양 수 증가
            sheep++;
        } else{
            // 늑대 증가
            wolf++;
        }

        // 늑대가 양보다 같거나 많은 경우 못감
        if(wolf >= sheep){
            return;
        }

        // 최대 양 수 업데이트
        maxSheep = Math.max(maxSheep, sheep);

        // 다음에 판단하기 위한 이동 가능 노드 리스트 복사하여 생성
        List<Integer> curNextNodes = new ArrayList<>(nextNodes);
        curNextNodes.remove(Integer.valueOf(cur));

        // 자식 노드 추가
        for(int child : map.get(cur)){
            curNextNodes.add(child);
        }

        for(int nn : curNextNodes){
            dfs(nn, sheep, wolf, curNextNodes, info);
        }
    }

    private void init(int[] info, int[][] edges){
        N = info.length;
        map = new ArrayList<>();
        maxSheep = 0;

        for(int i = 0; i < N; i++){
            map.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];

            map.get(from).add(to);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}});
        int solution2 = sol.solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0}, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9}, {9, 10}});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
