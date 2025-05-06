package programmers.Lv2.후보키;

import java.util.LinkedList;
import java.util.Queue;

import java.util.*;

class Solution {
    private int answer, N, M;
    private Set<String> set;
    private List<Set<Integer>> masterSet;
    private boolean[] visited;
    public int solution(String[][] relation) {
        // 초기화
        init(relation);
        // 풀이 과정
        solve(relation);

        return answer;
    }

    private void solve(String[][] relation){
        for(int len = 1; len <= M; len++){
            dfs(0, len, new HashSet<>(), relation);
        }
    }

    private void dfs(int idx, int len, Set<Integer> curSet, String[][] relation){
        if(curSet.size() == len){
            // 후보키인지 판단
            // 후보키이면 해당 키 값들 visited true로 변경
            if(isCandidateKey(relation, curSet) && !isAlreadyKey(curSet)){
                masterSet.add(new HashSet<>(curSet));
                answer++;
            }
            return;
        }

        for(int i = idx; i < M; i++){
            if(!visited[i]){
                visited[i] = true;
                curSet.add(i);
                dfs(i + 1, len, curSet, relation);
                visited[i] = false;
                curSet.remove(i);
            }
        }
    }

    private boolean isAlreadyKey(Set<Integer> curSet){
        for(Set<Integer> set : masterSet){
            if(curSet.containsAll(set)){
                return true;
            }
        }

        return false;
    }

    private boolean isCandidateKey(String[][] relation, Set<Integer> curSet){
        set = new HashSet<>();
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            for(int num : curSet){
                sb.append(relation[i][num]);
            }

            if(set.contains(sb.toString())){
                return false;
            }

            set.add(sb.toString());
        }

        return true;
    }

    private void init(String[][] relation){
        answer = 0;
        N = relation.length;
        M = relation[0].length;

        visited = new boolean[M];
        masterSet = new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});

        System.out.println("solution = " + solution);
    }
}
