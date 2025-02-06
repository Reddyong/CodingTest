package programmers.Lv2.튜플;

import java.util.*;

class Solution {
    private String[] tuples;
    private int[] answer;
    private List<Integer> ans;
    public int[] solution(String s) {
        init(s);
        solve();

        return answer;
    }

    private void solve(){
        answer = new int[tuples.length];
        ans = new ArrayList<>();

        Arrays.sort(tuples, (o1, o2) -> o1.length() - o2.length());

        for(String tuple : tuples){
            if(tuple.length() == 1){
                ans.add(Integer.parseInt(tuple));
                continue;
            }

            String[] split = tuple.split(",");

            for(int i = 0; i < split.length; i++){
                int cur = Integer.parseInt(split[i]);

                if(!ans.contains(cur)){
                    ans.add(cur);
                }
            }
        }

        for(int i = 0; i < answer.length; i++){
            answer[i] = ans.get(i);
        }
    }

    private void init(String s){
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "-");

        tuples = s.split("-");

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        int[] solution2 = sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        int[] solution3 = sol.solution("{{20,111},{111}}");
        int[] solution4 = sol.solution("{{123}}");
        int[] solution5 = sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
        System.out.println("solution4 = " + Arrays.toString(solution4));
        System.out.println("solution5 = " + Arrays.toString(solution5));
    }
}
