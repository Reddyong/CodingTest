package programmers.Lv3.단어변환;

import java.util.*;

class Solution {
    private boolean[] visited;
    private int answer;
    private int len;
    public int solution(String begin, String target, String[] words) {
        init(words);
        dfs(begin, target, 0, words);

        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }

        return answer;
    }

    private void dfs(String cur, String target, int depth, String[] words){
        if(cur.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(!visited[i] && isPossibleChange(cur, words[i])){
                visited[i] = true;
                dfs(words[i], target, depth + 1, words);
                visited[i] = false;
            }
        }
    }

    private boolean isPossibleChange(String cur, String next){
        int count = 0;

        for(int i = 0; i < len; i++){
            if(cur.charAt(i) == next.charAt(i)){
                count++;
            }
        }

        if(count == len - 1){
            return true;
        } else{
            return false;
        }
    }

    private void init(String[] words){
        visited = new boolean[words.length];
        answer = Integer.MAX_VALUE;
        len = words[0].length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        int solution2 = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}