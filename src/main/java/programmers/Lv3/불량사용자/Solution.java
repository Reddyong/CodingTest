package programmers.Lv3.불량사용자;

import java.util.*;

class Solution {
    private Set<Set<String>> result;
    private int answer;
    public int solution(String[] user_id, String[] banned_id) {
        solve(user_id, banned_id);

        return answer;
    }

    private void solve(String[] user_id, String[] banned_id){
        result = new HashSet<>();
        dfs(0, new HashSet<>(), user_id, banned_id);

        answer = result.size();
    }

    private void dfs(int depth, Set<String> set, String[] user_id, String[] banned_id){
        if(depth == banned_id.length){
            result.add(set);
            return;
        }

        for(int i = 0; i < user_id.length; i++){
            if(set.contains(user_id[i])){
                continue;
            }

            if(isBanned(banned_id[depth], user_id[i])){
                set.add(user_id[i]);
                dfs(depth + 1, new HashSet<>(set), user_id, banned_id);
                set.remove(user_id[i]);
            }
        }
    }

    private boolean isBanned(String ban, String id){
        if(ban.length() != id.length()){
            return false;
        }

        for(int i = 0; i < ban.length(); i++){
            char c1 = ban.charAt(i);
            char c2 = id.charAt(i);

            if(c1 != '*' && (c1 != c2)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
        int solution2 = sol.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
        int solution3 = sol.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
