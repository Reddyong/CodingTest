package programmers.Lv2.스킬트리;

import java.util.*;

class Solution {
    private Queue<String> queue;
    private int answer;
    public int solution(String skill, String[] skill_trees) {
        solve(skill, skill_trees);

        return answer;
    }

    private void solve(String skill, String[] skill_trees){
        answer = 0;

        for(String skill_tree : skill_trees){
            init(skill);
            String[] split = skill_tree.split("");

            if(check(split)){
                answer++;
                continue;
            }
        }
    }

    private boolean check(String[] split){
        for(String s : split){
            String peek = queue.peek();

            if(queue.contains(s)){
                if(s.equals(peek)){
                    queue.poll();
                } else{
                    return false;
                }
            }
        }

        return true;
    }

    private void init(String skill){
        queue = new LinkedList<>();
        String[] split = skill.split("");

        for(String s : split){
            queue.add(s);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});

        System.out.println("solution = " + solution);
    }
}
