package programmers.Lv3.이중우선순위큐;

import java.util.Arrays;


import java.util.*;

class Solution {
    private PriorityQueue<Integer> asc = new PriorityQueue<>();
    private PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
    private int[] answer = new int[2];
    public int[] solution(String[] operations) {
        solve(operations);

        return answer;
    }

    private void solve(String[] operations){
        for(String operation : operations){
            String[] split = operation.split(" ");

            if(split[0].equals("I")){
                asc.add(Integer.parseInt(split[1]));
                desc.add(Integer.parseInt(split[1]));
            } else{
                if(asc.isEmpty() && desc.isEmpty()){
                    continue;
                }

                if(split[1].equals("-1")){
                    Integer poll = asc.poll();
                    desc.remove(poll);
                } else{
                    Integer poll = desc.poll();
                    asc.remove(poll);
                }
            }
        }

        if(asc.isEmpty() && desc.isEmpty()){
            return;
        }

        answer[0] = desc.poll();
        answer[1] = asc.poll();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        int[] solution2 = sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
