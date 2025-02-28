package programmers.Lv2.소수찾기;

import java.util.*;

class Solution {
    private int N;
    private int answer;
    private String[] numberStrings;
    private boolean[] visited;
    private Set<Integer> set;
    public int solution(String numbers) {
        init(numbers);
        dfs("", 0);

        return answer;
    }

    private void dfs(String cur, int depth){
        if(isPrimeNumber(cur)){
            answer++;
        }

        if(depth == N){
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur + numberStrings[i], depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrimeNumber(String cur){
        if(cur.equals("")){
            return false;
        }

        int num = Integer.parseInt(cur);

        if(set.contains(num)){
            return false;
        }

        if(num == 1 || num == 0){
            return false;
        }

        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }

        set.add(num);
        return true;
    }

    private void init(String numbers){
        answer = 0;
        numberStrings = numbers.split("");
        N = numberStrings.length;
        visited = new boolean[N];
        set = new HashSet<>();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("17");
        int solution2 = sol.solution("011");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
