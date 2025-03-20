package programmers.Lv3.여행경로;

import java.util.*;

class Solution {
    private List<String> temp;
    private boolean[] visited;
    private String[] answer;
    public String[] solution(String[][] tickets) {
        init(tickets);
        solve(tickets);

        return answer;
    }

    private void solve(String[][] tickets){
        dfs("ICN", "ICN", 0, tickets);

        Collections.sort(temp);

        answer = temp.get(0).split(" ");
    }

    private void dfs(String pre, String cur, int count, String[][] tickets){
        if(count == tickets.length){
            temp.add(cur);
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && pre.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets[i][1], cur + " " + tickets[i][1], count + 1, tickets);
                visited[i] = false;
            }
        }
    }

    private void init(String[][] tickets){
        temp = new ArrayList<>();
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
