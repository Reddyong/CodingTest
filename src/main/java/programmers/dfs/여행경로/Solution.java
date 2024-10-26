package programmers.dfs.여행경로;

import java.util.*;

public class Solution {
    boolean[] visited;
    List<String> result;
    public String[] solution(String[][] tickets) {
        String[] answer = {};

        init(tickets);
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(result);

        answer = result.get(0).split(" ");

        return answer;
    }

    private void dfs(String start, String route, int depth, String[][] tickets) {
        if (depth == tickets.length) {
            result.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], depth + 1, tickets);
                visited[i] = false;
            }
        }
    }

    private void init(String[][] tickets) {
        result = new ArrayList<>();
        visited = new boolean[tickets.length];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] solution1 = sol.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        String[] solution2 = sol.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
